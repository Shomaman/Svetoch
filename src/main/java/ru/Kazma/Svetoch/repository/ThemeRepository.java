package ru.Kazma.Svetoch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Kazma.Svetoch.entity.ThemeEntity;

public interface ThemeRepository extends JpaRepository<ThemeEntity, Integer> {

}
