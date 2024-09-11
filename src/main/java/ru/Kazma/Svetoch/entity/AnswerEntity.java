package ru.Kazma.Svetoch.entity;

import java.util.Objects;

public class AnswerEntity {
    private Integer id;
    private String text;
    private boolean isCorrect;
    private QuestionEntity question;

    public AnswerEntity(Integer id, String text, boolean isCorrect) {
        this.id = id;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerEntity that = (AnswerEntity) o;
        return isCorrect == that.isCorrect && Objects.equals(id, that.id) && Objects.equals(text, that.text) && Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, isCorrect, question);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public QuestionEntity getQuestions() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }
}
