package ru.Kazma.Svetoch.repository;

import org.springframework.stereotype.Repository;
import ru.Kazma.Svetoch.entity.AnswerEntity;
import ru.Kazma.Svetoch.entity.QuestionEntity;
import ru.Kazma.Svetoch.entity.ThemeEntity;

import java.util.List;

@Repository
public class InMemoryQuestionRepository implements QuestionRepository {
    private final DB db;

    public InMemoryQuestionRepository(DB db) {

        this.db = db;
    }

    @Override
    public QuestionEntity findById(Integer questionId) {
        return db.getQuestions().stream().filter(q -> q.getId().equals(questionId)).findFirst().orElse(null);
    }

    @Override
    public void save(String title) {
        int questionId = db.getQuestions().stream().mapToInt(QuestionEntity::getId).max().orElse(0) + 1;
        QuestionEntity question = new QuestionEntity(questionId, title);
        db.getQuestions().add(question);
    }

    @Override
    public void delete(Integer questionId) {
        db.getQuestions().removeIf(q -> q.getId().equals(questionId));
    }

    @Override
    public void update(String title, Integer questionId) {
        QuestionEntity question = new QuestionEntity(questionId, title);
        db.getQuestions().set(questionId, question);
    }

    @Override
    public List<QuestionEntity> findAll(Integer themeId) {
        return db.getQuestions().stream().filter(q -> q.getTheme().getId().equals(themeId)).toList();
    }

    @Override
    public ThemeEntity getTheme() {
        return null;
    }

    @Override
    public List<AnswerEntity> getAnswers(Integer questionId) {
        return null;
    }
}
