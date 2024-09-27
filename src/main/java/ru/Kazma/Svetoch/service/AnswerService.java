package ru.Kazma.Svetoch.service;

import org.springframework.stereotype.Service;
import ru.Kazma.Svetoch.controller.Answer.dto.CreateAnswerDto;
import ru.Kazma.Svetoch.controller.Answer.dto.EditAnswerDto;
import ru.Kazma.Svetoch.entity.AnswerEntity;
import ru.Kazma.Svetoch.entity.QuestionEntity;
import ru.Kazma.Svetoch.repository.AnswerRepository;
import ru.Kazma.Svetoch.repository.QuestionRepository;
import java.util.List;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    public List<AnswerEntity> findAll() {
        return answerRepository.findAll();
    }


    public AnswerEntity create(CreateAnswerDto answer) {
        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setContent(answer.content());
        answerEntity.setCorrect(answer.isCorrect());
        answerEntity.setQuestion(questionRepository.findById(answer.questionId()).get());
        return answerRepository.save(answerEntity);
    }

    public void deleteById(Integer id) {
        answerRepository.deleteById(id);
    }

    public AnswerEntity findById(Integer id) {
        return answerRepository.findById(id).get();
    }

    public AnswerEntity edit(Integer id, EditAnswerDto answer) {
        AnswerEntity answerEntity = answerRepository.findById(id).get();
        answerEntity.setContent(answer.content());
        answerEntity.setCorrect(answer.isCorrect());
        answerEntity.setQuestion(questionRepository.findById(answer.questionId()).get());
        return  answerRepository.save(answerEntity);
    }

    public List<QuestionEntity> findAllQuestions() {
        return questionRepository.findAll();
    }
}
