package ru.Kazma.Svetoch.repository.inMemoryImpl;

import ru.Kazma.Svetoch.entity.AnswerEntity;

import java.util.List;

public class InMemoryAnswerRepository {
    private final DB db;

    public InMemoryAnswerRepository(DB db) {
        this.db = db;
    }

    public AnswerEntity findById(Integer answerId) {
        return db.getAnswers().stream().filter(answerEntity -> answerEntity.getId().equals(answerId)).findFirst().orElse(null);
    }

    public void save(String text, boolean isCorrect) {
        int answerId = db.getAnswers().stream().mapToInt(AnswerEntity::getId).max().orElse(0) + 1;
        AnswerEntity answer = new AnswerEntity(answerId, text, isCorrect);
        db.getAnswers().add(answer);
    }

    public void delete(Integer answerId) {
        db.getAnswers().removeIf(answerEntity -> answerEntity.getId().equals(answerId));
    }

    public void update(String text, boolean isCorrect, Integer answerId) {
        AnswerEntity answer = new AnswerEntity(answerId, text, isCorrect);

        db.getAnswers().set(answerId, answer);
    }

    public List<AnswerEntity> findAll() {
        return db.getAnswers();
    }
}
