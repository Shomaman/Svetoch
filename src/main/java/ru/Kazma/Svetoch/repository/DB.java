package ru.Kazma.Svetoch.repository;

import org.springframework.stereotype.Component;
import ru.Kazma.Svetoch.entity.AnswerEntity;
import ru.Kazma.Svetoch.entity.QuestionEntity;
import ru.Kazma.Svetoch.entity.ThemeEntity;

import java.util.List;

@Component
public class DB {
    private final List<ThemeEntity> themes;
    private final List<QuestionEntity> questions;
    private final List<AnswerEntity> answers;

    public List<ThemeEntity> getThemes() {
        return themes;
    }

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public List<AnswerEntity> getAnswers() {
        return answers;
    }

    public DB(List<ThemeEntity> themes, List<AnswerEntity> answers, List<QuestionEntity> questions) {
        this.themes = themes;
        this.answers = answers;
        this.questions = questions;
        themes.add(new ThemeEntity(1, "Default"));
        themes.add(new ThemeEntity(2, "Dark"));
        themes.add(new ThemeEntity(3, "Light"));
        questions.add(new QuestionEntity(1, "Вопрос 1"));
        questions.get(0).setTheme(themes.get(0));
        questions.get(0).setAnswers(answers);
        questions.add(new QuestionEntity(2, "Вопрос 2"));
        questions.get(1).setTheme(themes.get(0));
        questions.get(1).setAnswers(answers);
        questions.add(new QuestionEntity(3, "Вопрос 3"));
        questions.get(2).setTheme(themes.get(0));
        questions.get(2).setAnswers(answers);
        questions.add(new QuestionEntity(4, "Вопрос 4"));
        questions.get(3).setTheme(themes.get(1));
        questions.get(3).setAnswers(answers);
        questions.add(new QuestionEntity(5, "Вопрос 5"));
        questions.get(4).setTheme(themes.get(1));
        questions.get(4).setAnswers(answers);
        questions.add(new QuestionEntity(6, "Вопрос 6"));
        questions.get(5).setTheme(themes.get(1));
        questions.get(5).setAnswers(answers);
        questions.add(new QuestionEntity(7, "Вопрос 7"));
        questions.get(6).setTheme(themes.get(2));
        questions.get(6).setAnswers(answers);
        questions.add(new QuestionEntity(8, "Вопрос 8"));
        questions.get(7).setTheme(themes.get(2));
        questions.get(7).setAnswers(answers);
        questions.add(new QuestionEntity(9, "Вопрос 9"));
        questions.get(8).setTheme(themes.get(2));
        questions.get(8).setAnswers(answers);

        answers.add(new AnswerEntity(1, "Ответ 1", true));
        answers.get(0).setQuestion(questions.get(0));
        answers.add(new AnswerEntity(2, "Ответ 2", false));
        answers.get(1).setQuestion(questions.get(0));
        answers.add(new AnswerEntity(3, "Ответ 3", false));
        answers.get(2).setQuestion(questions.get(0));
        answers.add(new AnswerEntity(4, "Ответ 4", true));
        answers.get(3).setQuestion(questions.get(1));
        answers.add(new AnswerEntity(5, "Ответ 5", false));
        answers.get(4).setQuestion(questions.get(1));
        answers.add(new AnswerEntity(6, "Ответ 6", false));
        answers.get(5).setQuestion(questions.get(1));
        answers.add(new AnswerEntity(7, "Ответ 7", true));
        answers.get(6).setQuestion(questions.get(2));
        answers.add(new AnswerEntity(8, "Ответ 8", false));
        answers.get(7).setQuestion(questions.get(2));
        answers.add(new AnswerEntity(9, "Ответ 9", false));
        answers.get(8).setQuestion(questions.get(2));
        answers.add(new AnswerEntity(10, "Ответ 10", true));
        answers.get(9).setQuestion(questions.get(3));
        answers.add(new AnswerEntity(11, "Ответ 11", false));
        answers.get(10).setQuestion(questions.get(3));
        answers.add(new AnswerEntity(12, "Ответ 12", false));
        answers.get(11).setQuestion(questions.get(3));
        answers.add(new AnswerEntity(13, "Ответ 13", true));
        answers.get(12).setQuestion(questions.get(4));
        answers.add(new AnswerEntity(14, "Ответ 14", false));
        answers.get(13).setQuestion(questions.get(4));
        answers.add(new AnswerEntity(15, "Ответ 15", false));
        answers.get(14).setQuestion(questions.get(4));
        answers.add(new AnswerEntity(16, "Ответ 16", true));
        answers.get(15).setQuestion(questions.get(5));
        answers.add(new AnswerEntity(17, "Ответ 17", false));
        answers.get(16).setQuestion(questions.get(5));
        answers.add(new AnswerEntity(18, "Ответ 18", false));
        answers.get(17).setQuestion(questions.get(5));
        answers.add(new AnswerEntity(19, "Ответ 19", true));
        answers.get(18).setQuestion(questions.get(6));
        answers.add(new AnswerEntity(20, "Ответ 20", false));
        answers.get(19).setQuestion(questions.get(6));
        answers.add(new AnswerEntity(21, "Ответ 21", false));
        answers.get(20).setQuestion(questions.get(6));
        answers.add(new AnswerEntity(22, "Ответ 22", true));
        answers.get(21).setQuestion(questions.get(7));
        answers.add(new AnswerEntity(23, "Ответ 23", false));
        answers.get(22).setQuestion(questions.get(7));
        answers.add(new AnswerEntity(24, "Ответ 24", false));
        answers.get(23).setQuestion(questions.get(7));
        answers.add(new AnswerEntity(25, "Ответ 25", true));
        answers.get(24).setQuestion(questions.get(8));
        answers.add(new AnswerEntity(26, "Ответ 26", false));
        answers.get(25).setQuestion(questions.get(8));
        answers.add(new AnswerEntity(27, "Ответ 27", false));
        answers.get(26).setQuestion(questions.get(8));

    }
}
