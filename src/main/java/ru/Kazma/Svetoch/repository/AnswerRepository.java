package ru.Kazma.Svetoch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Kazma.Svetoch.entity.AnswerEntity;
import ru.Kazma.Svetoch.entity.QuestionEntity;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity,Integer> {

    List<AnswerEntity> findAllByQuestion(QuestionEntity question);
}
