package ru.Kazma.Svetoch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Kazma.Svetoch.entity.QuestionEntity;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity,Integer> {

    List<QuestionEntity> findByTheme_Id(Integer id);
}
