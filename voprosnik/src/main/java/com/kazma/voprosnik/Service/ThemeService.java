package com.kazma.voprosnik.Service;

import com.kazma.voprosnik.Model.Theme;
import com.kazma.voprosnik.Repository.ThemeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ThemeService {

    private final ThemeRepository repository;

    public void addTheme(Theme theme){
        repository.save(theme);
    }

    public Theme findTheme(Long id){
        return repository.findById(id).get();
    }

    public void deleteTheme(Theme theme){
        repository.delete(theme);
    }

    public List<Theme> getAllThemes(){
      return   repository.findAll();
    }
}
