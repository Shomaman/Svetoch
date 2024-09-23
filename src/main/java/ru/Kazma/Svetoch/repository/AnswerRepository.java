package ru.Kazma.Svetoch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Kazma.Svetoch.entity.AnswerEntity;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity,Integer> {

}
