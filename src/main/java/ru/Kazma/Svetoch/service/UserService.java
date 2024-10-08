package ru.Kazma.Svetoch.service;

import org.springframework.stereotype.Service;
import ru.Kazma.Svetoch.entity.AnswerEntity;
import ru.Kazma.Svetoch.entity.QuestionEntity;
import ru.Kazma.Svetoch.entity.ThemeEntity;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final ThemeService themeService;
    private final QuestionService questionService;

    public UserService(ThemeService themeService, QuestionService questionService) {
        this.themeService = themeService;
        this.questionService = questionService;
    }

    public List<ThemeEntity> getStart() {
        return themeService.findAll();
    }

    public List<QuestionEntity> getQuestions(int themeId) {
        return questionService.findQuestionsByThemeId(themeId);
    }

    public Integer getGrage(int themeId, List<String> answers) {
        List<QuestionEntity> questions = questionService.findQuestionsByThemeId(themeId);
        Integer grade = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (Objects.equals(answers.get(i), questions.get(i).getAnswers()
                    .stream()
                    .filter(AnswerEntity::isCorrect)
                    .findFirst()
                    .get())) {
                grade++;
            }
        }
        return grade;
    }

}
