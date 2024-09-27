package ru.Kazma.Svetoch.service;

import org.springframework.stereotype.Service;
import ru.Kazma.Svetoch.controller.Question.dto.CreateQuestionDto;
import ru.Kazma.Svetoch.controller.Question.dto.EditQuestionDto;
import ru.Kazma.Svetoch.entity.AnswerEntity;
import ru.Kazma.Svetoch.entity.QuestionEntity;
import ru.Kazma.Svetoch.entity.ThemeEntity;
import ru.Kazma.Svetoch.repository.AnswerRepository;
import ru.Kazma.Svetoch.repository.QuestionRepository;
import ru.Kazma.Svetoch.repository.ThemeRepository;

import java.util.List;

@Service
public class QuestionService {
    private final ThemeRepository themeRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    public QuestionService(ThemeRepository themeRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.themeRepository = themeRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public List<QuestionEntity> findAll() {
        return questionRepository.findAll();
    }


    public QuestionEntity create(CreateQuestionDto questionDto) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setTitle(questionDto.title());
        questionEntity.setTheme(themeRepository.findById(Integer.parseInt(questionDto.themeId())).get());
        return questionRepository.save(questionEntity);
    }

    public void deleteById(Integer id) {
        questionRepository.deleteById(id);
    }

    public QuestionEntity findById(Integer id) {
        return questionRepository.findById(id).get();
    }

    public QuestionEntity edit(Integer id, EditQuestionDto question) {
        QuestionEntity questionEntity = questionRepository.findById(id).get();
        questionEntity.setTitle(question.title());
        return  questionRepository.save(questionEntity);
    }

    public List<ThemeEntity> findAllThemes() {
        return themeRepository.findAll();
    }

    public List<AnswerEntity> findAllByQuestion(QuestionEntity questionEntity) {
        return answerRepository.findAllByQuestion(questionEntity);
    }
}
