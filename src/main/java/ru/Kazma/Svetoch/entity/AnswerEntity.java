package ru.Kazma.Svetoch.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "answers")
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "is_correct", nullable = false)
    private boolean isCorrect;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private QuestionEntity question;

    public AnswerEntity() {}
    public AnswerEntity(Integer id, String content, boolean isCorrect) {
        this.id = id;
        this.content = content;
        this.isCorrect = isCorrect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerEntity that = (AnswerEntity) o;
        return isCorrect == that.isCorrect && Objects.equals(id, that.id) && Objects.equals(content, that.content) && Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, isCorrect, question);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
