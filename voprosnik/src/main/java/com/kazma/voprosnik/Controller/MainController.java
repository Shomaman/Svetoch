package com.kazma.voprosnik.Controller;

import com.kazma.voprosnik.DTO.ThemeDTO;
import com.kazma.voprosnik.Model.Answer;
import com.kazma.voprosnik.Model.Question;
import com.kazma.voprosnik.Model.Theme;
import com.kazma.voprosnik.Service.AnswerService;
import com.kazma.voprosnik.Service.QuestionService;
import com.kazma.voprosnik.Service.ThemeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final ThemeService themeService;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private int countRigthAnswers;
    @GetMapping("/")
    public String index(Model model){
        List<Theme> themes = themeService.getAllThemes();
        model.addAttribute("themes", themes);
        return "index";
    }
    @GetMapping("/admin")
    public String admin(Model model){
        List<Theme> themes = themeService.getAllThemes();
        model.addAttribute("themes", themes);
        return "admin";
    }
    @PostMapping("/admin")
    public String addThema(@RequestParam String title, Model model){
        Theme theme = new Theme();
        theme.setTitle(title);
        theme.setQuestionList(new ArrayList<>());
        themeService.addTheme(theme);
        List<Theme> themes = themeService.getAllThemes();
        model.addAttribute("themes", themes);
        return "admin";
    }
    @PostMapping("/deleteTheme")
    public String deleteTheme(@RequestParam String id, Model model){
        themeService.deleteTheme(themeService.findTheme(Long.parseLong(id)));
        List<Theme> themes = themeService.getAllThemes();
        model.addAttribute("themes", themes);
        return "admin";
    }

    @PostMapping("/updateTheme")
    public String updateTheme(@RequestParam String id, String title,Model model){
        Theme theme = themeService.findTheme(Long.parseLong(id));
        theme.setTitle(title);
        themeService.addTheme(theme);
        List<Theme> themes = themeService.getAllThemes();
        model.addAttribute("themes", themes);
        return "admin";
    }
    @PostMapping("/checkTheme")
    public String checkTheme(@RequestParam String themeId, Model model){
        Theme theme = themeService.findTheme(Long.parseLong(themeId));
        model.addAttribute("questions", theme.getQuestionList());

        List<Theme> themes = themeService.getAllThemes();
        model.addAttribute("themes", themes);
        model.addAttribute("themeId", themeId);
        return "admin";
    }

    @PostMapping("/addQuestion")
    public String addQuestion(@RequestParam String titleQuestion,String themeId, Model model){
        questionService.addQuestion(titleQuestion, themeId);
        List<Question> questionList = questionService.getAllQuestions();
        List<Theme> themes = themeService.getAllThemes();
        model.addAttribute("themes", themes);
        model.addAttribute("questions", questionList);
        model.addAttribute("themeId", themeId);
        return "admin";
    }
    @PostMapping("/updateQuestion")
    public String updateQuestion(@RequestParam String titleQuestion,String questionId, Model model){
        questionService.updateQuestion(questionId, titleQuestion);
        List<Question> questionList = questionService.getAllQuestions();
        List<Theme> themes = themeService.getAllThemes();
        model.addAttribute("themes", themes);
        model.addAttribute("questions", questionList);
        return "admin";
    }

    @PostMapping("/deleteQuestion")
    public String deleteQuestion(@RequestParam String questionId, Model model){
        questionService.deleteQuestion(questionId);
        List<Question> questionList = questionService.getAllQuestions();
        List<Theme> themes = themeService.getAllThemes();
        model.addAttribute("themes", themes);
        model.addAttribute("questions", questionList);
        return "admin";
    }

    @PostMapping("/addAnswer")
    public String addAnswer(@RequestParam String questionId,String titleAnswer,String isRight, Model model){
        answerService.addAnswer(titleAnswer, isRight, questionId );
        List<Answer> answers = answerService.getAllAnswers();
        List<Question> questions = questionService.getAllQuestions();
        model.addAttribute("questions", questions);
        model.addAttribute("answers", answers);
        model.addAttribute("questionId", questionId);
        return "admin";
    }
    @PostMapping("/updateAnswer")
    public String updateAnswer(@RequestParam String answerId,String titleAnswer, String isRight, Model model){
        answerService.updateAnswer(answerId, titleAnswer,  isRight);
        List<Answer> answers = answerService.getAllAnswers();
        List<Question> questions = questionService.getAllQuestions();
        model.addAttribute("answers", answers);
        model.addAttribute("questions", questions);
        return "admin";
    }

    @PostMapping("/deleteAnswer")
    public String deleteAnswer(@RequestParam String answerId, Model model){
        answerService.deleteAnswer(answerId);
        List<Answer> answers = answerService.getAllAnswers();
        List<Question> questions = questionService.getAllQuestions();
        model.addAttribute("answers", answers);
        model.addAttribute("questions", questions);
        return "admin";
    }

    @PostMapping("/checkQuestion")
    public String checkQuestion(@RequestParam String questionId, Model model){
        log.info("THEMEID IS {}",questionId);
        Question question = questionService.findQuestion(questionId);
        model.addAttribute("answers", question.getAnswerList());
        List<Question> questions = questionService.getAllQuestions();
        model.addAttribute("questions", questions);
        model.addAttribute("questionId", questionId);
        return "admin";
    }

    @PostMapping("/checkThemeForTest")
    public String checkThemeForTest(@RequestParam String themeId, Model model){
        Theme theme = themeService.findTheme(Long.parseLong(themeId));
        model.addAttribute("questionTitle", theme.getQuestionList().get(0).getTitle());
        model.addAttribute("questionId", theme.getQuestionList().get(0).getId());
        model.addAttribute("themeId", themeId);
        model.addAttribute("answers", theme.getQuestionList().get(0).getAnswerList());
        return "index";
    }
    @PostMapping("/checkAnswer")
    public String checkAnswer(@RequestParam String themeId, String questionId, String isRight, Model model){
Answer answer = answerService.getAnswer(isRight);
        if(answer.getIsRight())countRigthAnswers++;
        Theme theme = themeService.findTheme(Long.parseLong(themeId));
        List<Question> questions = theme.getQuestionList();
        Question currentQuestion = questionService.findQuestion(questionId);
        int currentQuestionPosition = questions.indexOf(currentQuestion);

        if(currentQuestionPosition!=theme.getQuestionList().size()-1){
            currentQuestionPosition++;
        currentQuestion = theme.getQuestionList().get(currentQuestionPosition);
        model.addAttribute("answers", currentQuestion.getAnswerList());
        }
     
        model.addAttribute("countRigthAnswers", countRigthAnswers);
        model.addAttribute("questionId", currentQuestion.getId());
        model.addAttribute("questionTitle", currentQuestion.getTitle());
        model.addAttribute("themeId", themeId);
        return "index";
    }
}
