package ru.Kazma.Svetoch.admin.Question;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.Kazma.Svetoch.admin.Question.dto.CreateQuestionDto;
import ru.Kazma.Svetoch.admin.Question.dto.EditQuestionDto;
import ru.Kazma.Svetoch.entity.QuestionEntity;
import ru.Kazma.Svetoch.repository.QuestionRepository;

@Controller
@RequestMapping("/admin")
public class QuestionController {
    private final QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/questions")
    public String getStartPage(Model model) {
        model.addAttribute("questions", questionRepository.findAll());
        return "admin/question/questions";
    }

    @GetMapping("question/create")
    public String createNewQuestion() {
        return "admin/question/create";
    }

    @PostMapping("question/create")
    public String createNewQuestion(@RequestParam("title") CreateQuestionDto question) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setTitle(question.title());
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
