package ru.Kazma.Svetoch.admin.Question;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.Kazma.Svetoch.admin.Question.dto.CreateQuestionDto;
import ru.Kazma.Svetoch.admin.Question.dto.EditQuestionDto;
import ru.Kazma.Svetoch.entity.QuestionEntity;
import ru.Kazma.Svetoch.repository.AnswerRepository;
import ru.Kazma.Svetoch.repository.QuestionRepository;
import ru.Kazma.Svetoch.repository.ThemeRepository;

@Controller
@RequestMapping("/admin")
public class QuestionController {
    private final QuestionRepository questionRepository;
    private final ThemeRepository themeRepository;
    private final AnswerRepository answerRepository;
    public QuestionController(QuestionRepository questionRepository, ThemeRepository themeRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.themeRepository = themeRepository;
        this.answerRepository = answerRepository;
    }

    @GetMapping("/questions")
    public String getStartPage(Model model) {
        model.addAttribute("questions", questionRepository.findAll());
        return "admin/question/questions";
    }

    @GetMapping("question/create")
    public String createNewQuestion(Model model) {
        model.addAttribute("themes", themeRepository.findAll());
        return "admin/question/create";
    }

    @PostMapping("question/create")
    public String createNewQuestion(@ModelAttribute CreateQuestionDto question) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setTitle(question.title());
        questionEntity.setTheme(themeRepository.findById(Integer.parseInt(question.themeId())).get());
        questionRepository.save(questionEntity);
        return "redirect:/admin/questions";
    }

    @DeleteMapping("question/delete")
    public void deleteQuestion(@RequestParam Integer id) {
        questionRepository.deleteById(id);
    }

    @GetMapping("question/edit")
    public String editQuestion(@RequestParam Integer id, Model model) {
        QuestionEntity questionEntity = questionRepository.findById(id).get();
        model.addAttribute("question", questionEntity);
        model.addAttribute("answers", answerRepository.findAllByQuestion(questionEntity));
        return "admin/question/edit";
    }

    @PutMapping("question/edit")
    public String editQuestion(@RequestParam Integer id, @RequestParam EditQuestionDto question) {
        QuestionEntity questionEntity = questionRepository.findById(id).get();
        questionEntity.setTitle(question.title());
        questionRepository.save(questionEntity);
        return "redirect:/admin/questions";
    }
}
