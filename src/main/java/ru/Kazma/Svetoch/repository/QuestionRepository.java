package ru.Kazma.Svetoch.repository;

import ru.Kazma.Svetoch.entity.AnswerEntity;
import ru.Kazma.Svetoch.entity.QuestionEntity;
import ru.Kazma.Svetoch.entity.ThemeEntity;

import java.util.List;

public interface QuestionRepository {
    QuestionEntity findById(Integer questionId);

    void save(String title);

    void delete(Integer questionId);

    void update(String title, Integer questionId);

    List<QuestionEntity> findAll(Integer themeId);

    ThemeEntity getTheme();

    List<AnswerEntity> getAnswers(Integer questionId);
}
