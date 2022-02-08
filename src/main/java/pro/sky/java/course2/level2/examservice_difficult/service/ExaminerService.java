package pro.sky.java.course2.level2.examservice_difficult.service;

import pro.sky.java.course2.level2.examservice_difficult.domain.Question;

import java.util.Collection;

/**
 * сервис студента
 * получить экзаменационные вопросы
 * Доработать ExaminerService на получение случайного набора вопросов
 * не только из JavaQuestionService, но и из MathQuestionService
 */
public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}

