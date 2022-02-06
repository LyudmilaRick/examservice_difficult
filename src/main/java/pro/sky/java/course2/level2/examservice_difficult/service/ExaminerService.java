package pro.sky.java.course2.level2.examservice_difficult.service;

/**
 * сервис студента
 * получить экзаменационные вопросы
 * Доработать ExaminerService на получение случайного набора вопросов
 * не только из JavaQuestionService, но и из MathQuestionService
 */
public interface ExaminerService {
    Object getQuestion(int amount);
}

