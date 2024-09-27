package ru.Kazma.Svetoch.controller.Answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.Kazma.Svetoch.controller.Answer.dto.CreateAnswerDto;
import ru.Kazma.Svetoch.controller.Answer.dto.EditAnswerDto;
import ru.Kazma.Svetoch.entity.AnswerEntity;
import ru.Kazma.Svetoch.service.AnswerService;

@Controller
@RequestMapping("/admin")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/answers")
    public String getStartPage(Model model) {
        model.addAttribute("answers", answerService.findAll());
        return "admin/answer/answers";
    }

    @GetMapping("answer/create")
    public String createNewAnswer(Model model) {
        model.addAttribute("questions", answerService.findAllQuestions());
        return "admin/answer/create";
    }

    @PostMapping("answer/create")
    public String createNewAnswer(@ModelAttribute CreateAnswerDto answerDto) {
        answerService.create(answerDto);
        return "redirect:/admin/answers";
    }

    @PostMapping("answer/delete")
    public String deleteAnswer(@RequestParam Integer id) {
        answerService.deleteById(id);
        return "redirect:/admin/answers";
    }

    @GetMapping("answer/edit")
    public String editAnswer(@RequestParam Integer id, Model model) {
        AnswerEntity answerEntity = answerService.findById(id);
        model.addAttribute("answer", answerEntity);
        return "admin/answer/edit";
    }

    @PostMapping("answer/edit")
    public String editAnswer(@RequestParam Integer id, @RequestParam EditAnswerDto answerDto) {
        answerService.edit(id, answerDto);
        return "redirect:/admin/answers";
    }
}
