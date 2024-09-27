package ru.Kazma.Svetoch.admin.Answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.Kazma.Svetoch.admin.Answer.dto.CreateAnswerDto;
import ru.Kazma.Svetoch.admin.Answer.dto.EditAnswerDto;
import ru.Kazma.Svetoch.entity.AnswerEntity;
import ru.Kazma.Svetoch.repository.AnswerRepository;
import ru.Kazma.Svetoch.repository.QuestionRepository;
import ru.Kazma.Svetoch.repository.ThemeRepository;

@Controller
@RequestMapping("/admin")
public class AnswerController {
    private final ThemeRepository themeRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    public AnswerController(ThemeRepository themeRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.themeRepository = themeRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @GetMapping("/answers")
    public String getStartPage(Model model) {
        model.addAttribute("answers", answerRepository.findAll());
        return "admin/answer/answers";
    }
    @GetMapping("answer/create")
    public String createNewAnswer(Model model) {
        model.addAttribute("questions", questionRepository.findAll());
        return "admin/answer/create";
    }

    @PostMapping("answer/create")
    public String createNewAnswer(@ModelAttribute CreateAnswerDto answer) {
        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setContent(answer.content());
        answerEntity.setCorrect(answer.isCorrect());
        answerEntity.setQuestion(questionRepository.findById(answer.questionId()).get());
        answerRepository.save(answerEntity);
        return "redirect:/admin/answers";
    }
    @DeleteMapping("answer/delete")
    public void deleteAnswer(@RequestParam Integer id) {
        answerRepository.deleteById(id);
    }

    @GetMapping("answer/edit")
    public String editAnswer(@RequestParam Integer id, Model model) {
        AnswerEntity answerEntity = answerRepository.findById(id).get();
        model.addAttribute("answer", answerEntity);
        return "admin/answer/edit";
    }
    @PutMapping("answer/edit")
    public String editAnswer(@RequestParam Integer id, @RequestParam EditAnswerDto answer) {
        AnswerEntity answerEntity = answerRepository.findById(id).get();
        answerEntity.setContent(answer.title());
        answerRepository.save(answerEntity);
        return "redirect:/admin/answers";
    }
}
