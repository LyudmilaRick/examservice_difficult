package pro.sky.java.course2.level2.examservice_difficult.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.level2.examservice_difficult.domain.Question;
import pro.sky.java.course2.level2.examservice_difficult.service.ExaminerService;

import java.util.Collection;

/**
 * контроллер
 * Доработать JavaQuestionController, так как вторая реализация QuestionService сломала корректный инжект по интерфейсу
 */
@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(value = "/get")
    Collection<Question> getQuestion(@RequestParam(name = "amount") int value) {
        return (Collection<Question>) examinerService.getQuestion(value);
    }
}
