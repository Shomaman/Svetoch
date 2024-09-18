package ru.Kazma.Svetoch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Kazma.Svetoch.entity.AnswerEntity;
import ru.Kazma.Svetoch.entity.QuestionEntity;
import ru.Kazma.Svetoch.entity.ThemeEntity;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity,Long> {

}
