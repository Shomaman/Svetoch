package ru.Kazma.Svetoch.repository.inMemoryImpl;

import ru.Kazma.Svetoch.entity.QuestionEntity;
import ru.Kazma.Svetoch.entity.ThemeEntity;

import java.util.List;

public class InMemoryThemeRepository {
    private final DB db;

    public InMemoryThemeRepository(DB db) {
        this.db = db;
    }


    public ThemeEntity findById(Integer themeId) {
        return db.getThemes().stream().filter(t -> t.getId().equals(themeId)).findFirst().orElse(null);
    }


    public void save(String title) {
        int themeId = db.getThemes()
                .stream()
                .map(ThemeEntity::getId)
                .max(Integer::compareTo)
                .orElse(0) + 1;
        ThemeEntity theme = new ThemeEntity(themeId, title);
        db.getThemes().add(theme);
    }


    public void delete(Integer themeId) {
        db.getThemes().removeIf(t -> t.getId().equals(themeId));
    }


    public void update(String title, Integer themeId) {
        ThemeEntity theme = new ThemeEntity(themeId, title);
        db.getThemes().set(themeId, theme);
    }


    public List<ThemeEntity> findAll() {
        return db.getThemes();
    }


    public List<QuestionEntity> findAllQuestionsByThemeId(Integer themeId) {
        return null;
    }
}
