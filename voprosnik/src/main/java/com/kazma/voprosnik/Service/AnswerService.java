package com.kazma.voprosnik.Service;

import com.kazma.voprosnik.Model.Answer;
import com.kazma.voprosnik.Repository.AnswerRepository;
import com.kazma.voprosnik.Repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.And;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    public void addAnswer(String answer,String isRigth, String questionId){
        Answer answer1 = new Answer();
        answer1.setTitle(answer);
        answer1.setQuestion(questionRepository.findById(Long.parseLong(questionId)).get());
        answer1.setIsRight(Boolean.valueOf(isRigth));
        answerRepository.save(answer1);
    }
    public void deleteAnswer(String answerId){
        Answer answer = answerRepository.findById(Long.parseLong(answerId)).get();
        answerRepository.delete(answer);
    }

    public void updateAnswer(String answerId, String answerText, String isRigth){
        Answer answer = answerRepository.findById(Long.parseLong(answerId)).get();
        answer.setIsRight(Boolean.valueOf(isRigth));
        answer.setTitle(answerText);
        answerRepository.save(answer);
    }

    public List<Answer> getAllAnswers(){
        return answerRepository.findAll();
    }

    public Answer getAnswer(String answerId){
        return answerRepository.findById(Long.parseLong(answerId)).get();
    }
}
