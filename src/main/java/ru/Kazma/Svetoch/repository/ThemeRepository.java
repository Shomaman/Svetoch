package ru.Kazma.Svetoch.repository;

import ru.Kazma.Svetoch.entity.QuestionEntity;
import ru.Kazma.Svetoch.entity.ThemeEntity;

import java.util.List;

public interface ThemeRepository {
    ThemeEntity findById(Integer themeId);

    void save(String title);

    void delete(Integer themeId);

    void update(String title, Integer themeId);

    List<ThemeEntity> findAll();

    List<QuestionEntity> findAllQuestionsByThemeId(Integer themeId);
}
