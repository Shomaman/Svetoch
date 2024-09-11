package ru.Kazma.Svetoch.entity;

import java.util.List;
import java.util.Objects;

public class ThemeEntity {
    private Integer id;
    private String title;
    private List<QuestionEntity> questions;

    public ThemeEntity(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThemeEntity that = (ThemeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(questions, that.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, questions);
    }
}
