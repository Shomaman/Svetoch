package ru.Kazma.Svetoch.service;

import org.springframework.stereotype.Service;
import ru.Kazma.Svetoch.controller.Theme.dto.CreateThemeDto;
import ru.Kazma.Svetoch.controller.Theme.dto.EditThemeDto;
import ru.Kazma.Svetoch.entity.QuestionEntity;
import ru.Kazma.Svetoch.entity.ThemeEntity;
import ru.Kazma.Svetoch.repository.QuestionRepository;
import ru.Kazma.Svetoch.repository.ThemeRepository;
import java.util.List;

@Service
public class ThemeService {
    private final ThemeRepository themeRepository;
    private final QuestionRepository questionRepository;

    public ThemeService(ThemeRepository themeRepository, QuestionRepository questionRepository) {
        this.themeRepository = themeRepository;
        this.questionRepository = questionRepository;
    }

    public List<ThemeEntity> findAll() {
        return themeRepository.findAll();
    }


    public ThemeEntity create(CreateThemeDto theme) {
        ThemeEntity themeEntity = new ThemeEntity();
        themeEntity.setTitle(theme.title());
        return themeRepository.save(themeEntity);
    }

    public void deleteById(Integer id) {
        themeRepository.deleteById(id);
    }

    public ThemeEntity findById(Integer id) {
        return themeRepository.findById(id).get();
    }

    public ThemeEntity edit(Integer id, EditThemeDto theme) {
        ThemeEntity themeEntity = themeRepository.findById(id).get();
        themeEntity.setTitle(theme.title());
        return  themeRepository.save(themeEntity);
    }

    public List<QuestionEntity> findByTheme_Id(Integer id) {
        return questionRepository.findByTheme_Id(id);
    }
}
