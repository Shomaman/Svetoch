package ru.Kazma.Svetoch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Kazma.Svetoch.entity.QuestionEntity;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity,Long> {

}
