package pro.sky.java.course2.level2.examservice_difficult.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.level2.examservice_difficult.domain.Question;
import pro.sky.java.course2.level2.examservice_difficult.exeption.NotEnoughQuestionsException;
import pro.sky.java.course2.level2.examservice_difficult.service.ExaminerService;
import pro.sky.java.course2.level2.examservice_difficult.service.QuestionService;

import java.util.*;

/**
 * Реализовать ExaminerServiceImpl
 * Его задача: создать коллекцию и заполнить её
 * с помощью вызова getRandomQuestion у QuestionService случайными вопросами.
 */
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private static final Logger log = LoggerFactory.getLogger(JavaQuestionService.class);
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    private final Random random = new Random();
    private int count;

    public ExaminerServiceImpl(
            @Qualifier("javaService") QuestionService javaQuestionService,
            @Qualifier("mathService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
        count = javaQuestionService.getCount() + mathQuestionService.getCount();
        log.info("count" + count);
    }

    /**
     * Включать в запрос вопросы не только по джаве, но и по математике.
     * Количество вопросов по каждой из тем выбирать случайно.
     */

    @Override
    public Collection<Question> getQuestion(int amount) {
        Set<Question> examCollection = new HashSet<>();
        if (checkAmount(amount)) {
            throw new NotEnoughQuestionsException();
        }
        while (examCollection.size() < amount) {
            // вернет 0 или 1
            int randomInt = random.nextInt(2);
            if (randomInt == 0) {
                examCollection.add(javaQuestionService.getRandomQuestion());
            } else {
                examCollection.add(mathQuestionService.getRandomQuestion());
            }
        }
        return examCollection;
    }

    protected boolean checkAmount(int amount) {
        return amount == 0 || amount > count;
    }
}

