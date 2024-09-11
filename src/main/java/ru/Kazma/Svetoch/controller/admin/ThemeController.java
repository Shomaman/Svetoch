package ru.Kazma.Svetoch.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.Kazma.Svetoch.repository.ThemeRepository;

@Controller
@RequestMapping("/admin")
public class ThemeController {
    private final ThemeRepository themeRepository;

    public ThemeController(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    @GetMapping("/")
    public String getStartPage(Model model) {
        model.addAttribute("themes", themeRepository.findAll());
        System.out.println(themeRepository.findAll().toString());
        return "admin/index";
    }

}
