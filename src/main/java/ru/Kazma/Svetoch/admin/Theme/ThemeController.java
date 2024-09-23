package ru.Kazma.Svetoch.admin.Theme;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.Kazma.Svetoch.admin.Theme.dto.CreateThemeDto;
import ru.Kazma.Svetoch.admin.Theme.dto.EditThemeDto;
import ru.Kazma.Svetoch.entity.ThemeEntity;
import ru.Kazma.Svetoch.repository.ThemeRepository;

@Controller
@RequestMapping("/admin")
public class ThemeController {
    private final ThemeRepository themeRepository;

    public ThemeController(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    @GetMapping("/themes")
    public String getStartPage(Model model) {
        model.addAttribute("themes", themeRepository.findAll());
        System.out.println(themeRepository.findAll());
        return "admin/index";
    }
    @GetMapping("theme/create")
    public String createNewTheme() {
        return "admin/theme/create";
    }
    @PostMapping("theme/create")
    public String createNewTheme(@RequestParam("title") CreateThemeDto theme) {
        ThemeEntity themeEntity = new ThemeEntity();
        themeEntity.setTitle(theme.title());
        themeRepository.save(themeEntity);
        return "redirect:/admin/";
    }
    @DeleteMapping("theme/delete")
    public void deleteTheme(@RequestParam Integer id) {
        themeRepository.deleteById(id);
    }
    @GetMapping("theme/edit")
    public String editTheme(@RequestParam Integer id, Model model) {
        ThemeEntity themeEntity = themeRepository.findById(id).get();
        model.addAttribute("theme", themeEntity);
        return "admin/theme/edit";
    }
    @PutMapping("theme/edit")
    public String editTheme(@RequestParam Integer id, @RequestParam EditThemeDto theme) {
        ThemeEntity themeEntity = themeRepository.findById(id).get();
        themeEntity.setTitle(theme.title());
        themeRepository.save(themeEntity);
        return "redirect:/admin/themes";
    }
}
