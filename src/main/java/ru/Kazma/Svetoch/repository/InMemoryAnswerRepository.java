package ru.Kazma.Svetoch.repository;

import org.springframework.stereotype.Repository;
import ru.Kazma.Svetoch.entity.AnswerEntity;

import java.util.List;

@Repository
public class InMemoryAnswerRepository implements AnswerRepository {
    private final DB db;

    public InMemoryAnswerRepository(DB db) {
        this.db = db;
    }

    @Override
    public AnswerEntity findById(Integer answerId) {
        return db.getAnswers().stream().filter(answerEntity -> answerEntity.getId().equals(answerId)).findFirst().orElse(null);
    }

    @Override
    public void save(String text, boolean isCorrect) {
        int answerId = db.getAnswers().stream().mapToInt(AnswerEntity::getId).max().orElse(0) + 1;
        AnswerEntity answer = new AnswerEntity(answerId, text, isCorrect);
        db.getAnswers().add(answer);
    }

    @Override
    public void delete(Integer answerId) {
        db.getAnswers().removeIf(answerEntity -> answerEntity.getId().equals(answerId));
    }

    @Override
    public void update(String text, boolean isCorrect, Integer answerId) {
        AnswerEntity answer = new AnswerEntity(answerId, text, isCorrect);
        
        db.getAnswers().set(answerId, answer);
    }

    @Override
    public List<AnswerEntity> findAll() {
        return db.getAnswers();
    }
}
