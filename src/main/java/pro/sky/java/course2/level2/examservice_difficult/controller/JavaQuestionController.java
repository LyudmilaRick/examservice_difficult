package pro.sky.java.course2.level2.examservice_difficult.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.level2.examservice_difficult.domain.Question;
import pro.sky.java.course2.level2.examservice_difficult.service.QuestionService;

import java.util.Collection;
import java.util.Random;

/**
 * контроллер
 * Доработать JavaQuestionController,
 * так как вторая реализация QuestionService сломала корректный инжект по интерфейсу.
 * Может потребоваться аннотация @Qualifier.
 */
@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(@Qualifier("javaService") QuestionService questionService) {
        this.questionService = questionService;
    }

    /**
     * @param question question
     * @param answer   answer
     * @return Question
     */
    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        Question item = new Question(question, answer);
        return questionService.remove(item);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}

