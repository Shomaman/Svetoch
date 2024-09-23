package ru.Kazma.Svetoch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Kazma.Svetoch.entity.ThemeEntity;

@Repository
public interface ThemeRepository extends JpaRepository<ThemeEntity, Integer> {

}
