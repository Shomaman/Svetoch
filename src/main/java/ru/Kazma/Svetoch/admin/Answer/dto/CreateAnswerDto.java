package ru.Kazma.Svetoch.admin.Answer.dto;

public record CreateAnswerDto(String content, Boolean isCorrect, Integer questionId) {

}
