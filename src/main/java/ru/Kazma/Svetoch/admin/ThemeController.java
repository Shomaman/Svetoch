package ru.Kazma.Svetoch.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.Kazma.Svetoch.entity.ThemeEntity;
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
        System.out.println(themeRepository.findAll());
        return "admin/index";
    }
    @GetMapping("/create")
    public String createNewTheme() {
        return "admin/create";
    }
    @PostMapping("/create")
    public String createNewTheme(@RequestParam("title")ThemeDto theme) {
        ThemeEntity themeEntity = new ThemeEntity();
        themeEntity.setTitle(theme.title());
        themeRepository.save(themeEntity);
        return "redirect:/admin/";
    }

}
