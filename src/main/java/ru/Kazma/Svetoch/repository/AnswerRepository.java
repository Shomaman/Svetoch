package ru.Kazma.Svetoch.repository;

import ru.Kazma.Svetoch.entity.AnswerEntity;

import java.util.List;

public interface AnswerRepository {
    AnswerEntity findById(Integer answerId);

    void save(String text, boolean isCorrect);

    void delete(Integer answerId);

    void update(String text, boolean isCorrect, Integer answerId);

    List<AnswerEntity> findAll();

}
