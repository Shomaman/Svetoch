package com.kazma.voprosnik.Service;

import com.kazma.voprosnik.Model.Answer;
import com.kazma.voprosnik.Model.Question;
import com.kazma.voprosnik.Model.Theme;
import com.kazma.voprosnik.Repository.QuestionRepository;
import com.kazma.voprosnik.Repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final ThemeRepository themeRepository;
    public void addQuestion(String question, String themeId){
        Question beforeSavedQuestion = new Question();
        beforeSavedQuestion.setTitle(question);
        beforeSavedQuestion.setTheme(themeRepository.findById(Long.parseLong(themeId)).get());
        beforeSavedQuestion.setAnswerList(new ArrayList<>());
        Question afterSavedQuestion = questionRepository.save(beforeSavedQuestion);
        /*Theme theme = themeRepository.findById(Long.parseLong(themeId)).get();
        List<Question> questionList = theme.getQuestionList();
        questionList.add(afterSavedQuestion);*/
    }
    public void deleteQuestion(String questionId){
        Question question = questionRepository.findById(Long.parseLong(questionId)).get();
        questionRepository.delete(question);
       /* Theme theme = themeRepository.findById(Long.parseLong(themeId)).get();
        List<Question> questionList = theme.getQuestionList();
        questionList.remove(question);*/
    }

    public Question findQuestion(String questionId){
        return questionRepository.findById(Long.parseLong(questionId)).get();
    }

    public void updateQuestion(String questionId, String questionText){
        Question question = questionRepository.findById(Long.parseLong(questionId)).get();
        question.setTitle(questionText);
        questionRepository.save(question);
        /*Theme theme = themeRepository.findById(Long.parseLong(themeId)).get();
        List<Question> questionList = theme.getQuestionList();
        int positionOldQestion = questionList.indexOf(question);
        questionList.set(positionOldQestion,question);*/
    }

    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }
}
