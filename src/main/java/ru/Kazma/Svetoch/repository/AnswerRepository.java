package ru.Kazma.Svetoch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Kazma.Svetoch.entity.AnswerEntity;

import java.util.List;

public interface AnswerRepository extends JpaRepository<AnswerEntity,Integer> {

}
