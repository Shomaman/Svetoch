package ru.Kazma.Svetoch.controller.Answer.dto;

public record CreateAnswerDto(String content, Boolean isCorrect, Integer questionId) {

}
