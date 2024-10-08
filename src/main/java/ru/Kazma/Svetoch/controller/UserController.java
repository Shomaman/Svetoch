package ru.Kazma.Svetoch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.Kazma.Svetoch.entity.QuestionEntity;
import ru.Kazma.Svetoch.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("themes", userService.getStart());
        return "user/main";
    }

    @GetMapping("testing/{themeId}")
    public String getQuestions(@PathVariable("themeId") int themeId, Model model) {
        List<QuestionEntity> questions = userService.getQuestions(themeId);
        model.addAttribute("questions", questions);
        return "user/test";
    }

    @PostMapping("testing/{themeId}")
    public String getGrage(@PathVariable("themeId") int themeId, List<String> answers, Model model,
                           ModelMap modelMap) {
        Integer grage = userService.getGrage(themeId, answers);
        model.addAttribute("result", grage);
        return "user/result";
    }
}
