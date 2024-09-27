package ru.Kazma.Svetoch.controller.Theme;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.Kazma.Svetoch.controller.Theme.dto.CreateThemeDto;
import ru.Kazma.Svetoch.controller.Theme.dto.EditThemeDto;
import ru.Kazma.Svetoch.entity.ThemeEntity;
import ru.Kazma.Svetoch.service.ThemeService;

@Controller
@RequestMapping("/admin")
public class ThemeController {
    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping("/themes")
    public String getStartPage(Model model) {
        model.addAttribute("themes", themeService.findAll());
        return "admin/theme/themes";
    }

    @GetMapping("theme/create")
    public String createNewTheme() {
        return "admin/theme/create";
    }

    @PostMapping("theme/create")
    public String createNewTheme(@RequestParam("title") CreateThemeDto theme) {
        themeService.create(theme);
        return "redirect:/admin/themes";
    }

    @PostMapping("theme/delete")
    public String deleteTheme(@RequestParam Integer id) {
        themeService.deleteById(id);
        return "redirect:/admin/themes";
    }

    @GetMapping("theme/edit")
    public String editTheme(@RequestParam Integer id, Model model) {
        ThemeEntity themeEntity = themeService.findById(id);
        model.addAttribute("theme", themeEntity);
        model.addAttribute("questions", themeService.findByTheme_Id(id));
        return "admin/theme/edit";
    }

    @PostMapping("theme/edit")
    public String editTheme(@RequestParam Integer id, @RequestParam EditThemeDto theme) {
        themeService.edit(id, theme);
        return "redirect:/admin/themes";
    }
}
