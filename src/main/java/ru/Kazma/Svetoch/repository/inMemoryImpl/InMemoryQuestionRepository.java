package ru.Kazma.Svetoch.repository.inMemoryImpl;

import ru.Kazma.Svetoch.entity.AnswerEntity;
import ru.Kazma.Svetoch.entity.QuestionEntity;
import ru.Kazma.Svetoch.entity.ThemeEntity;

import java.util.List;

public class InMemoryQuestionRepository {
    private final DB db;

    public InMemoryQuestionRepository(DB db) {
        this.db = db;
    }

    public QuestionEntity findById(Integer questionId) {
        return db.getQuestions().stream().filter(q -> q.getId().equals(questionId)).findFirst().orElse(null);
    }

    public void save(String title) {
        int questionId = db.getQuestions().stream().mapToInt(QuestionEntity::getId).max().orElse(0) + 1;
        QuestionEntity question = new QuestionEntity(questionId, title);
        db.getQuestions().add(question);
    }

    public void delete(Integer questionId) {
        db.getQuestions().removeIf(q -> q.getId().equals(questionId));
    }

    public void update(String title, Integer questionId) {
        QuestionEntity question = new QuestionEntity(questionId, title);
        db.getQuestions().set(questionId, question);
    }

    public List<QuestionEntity> findAll(Integer themeId) {
        return db.getQuestions().stream().filter(q -> q.getTheme().getId().equals(themeId)).toList();
    }

    public ThemeEntity getTheme() {
        return null;
    }

    public List<AnswerEntity> getAnswers(Integer questionId) {
        return null;
    }
}
