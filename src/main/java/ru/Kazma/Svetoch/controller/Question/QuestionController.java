package ru.Kazma.Svetoch.controller.Question;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.Kazma.Svetoch.controller.Question.dto.CreateQuestionDto;
import ru.Kazma.Svetoch.controller.Question.dto.EditQuestionDto;
import ru.Kazma.Svetoch.entity.QuestionEntity;
import ru.Kazma.Svetoch.service.QuestionService;

@Controller
@RequestMapping("/admin")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public String getStartPage(Model model) {
        model.addAttribute("questions", questionService.findAll());
        return "admin/question/questions";
    }

    @GetMapping("question/create")
    public String createNewQuestion(Model model) {
        model.addAttribute("themes", questionService.findAllThemes());
        return "admin/question/create";
    }

    @PostMapping("question/create")
    public String createNewQuestion(@ModelAttribute CreateQuestionDto questionDto) {
        questionService.create(questionDto);
        return "redirect:/admin/questions";
    }

    @PostMapping("question/delete")
    public String deleteQuestion(@RequestParam Integer id) {
        questionService.deleteById(id);
        return "redirect:/admin/questions";
    }

    @GetMapping("question/edit")
    public String editQuestion(@RequestParam Integer id, Model model) {
        QuestionEntity questionEntity = questionService.findById(id);
        model.addAttribute("question", questionEntity);
       model.addAttribute("answers", questionService.findAllByQuestion(questionEntity));
        return "admin/question/edit";
    }

    @PostMapping("question/edit")
    public String editQuestion(@RequestParam Integer id, @RequestParam EditQuestionDto questionDto) {
        questionService.edit(id, questionDto);
        return "redirect:/admin/questions";
    }
}
