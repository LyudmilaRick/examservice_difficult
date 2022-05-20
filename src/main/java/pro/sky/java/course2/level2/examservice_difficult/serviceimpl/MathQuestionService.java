package pro.sky.java.course2.level2.examservice_difficult.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.level2.examservice_difficult.domain.Question;
import pro.sky.java.course2.level2.examservice_difficult.exeption.QuestionNotExistException;
import pro.sky.java.course2.level2.examservice_difficult.service.QuestionRepository;
import pro.sky.java.course2.level2.examservice_difficult.service.QuestionService;

import java.util.Collection;
import java.util.Random;

@Service("mathService")
public class MathQuestionService implements QuestionService {
    private static final Logger log = LoggerFactory.getLogger(MathQuestionService.class);
    private final QuestionRepository mathQuestionRepository;
    private final Random random = new Random();
    private int count = 0;

    public MathQuestionService(@Qualifier("mathRepository") QuestionRepository javaQuestionRepository) {
        this.mathQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return mathQuestionRepository.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public int getCount() {
        return mathQuestionRepository.getCount();
    }

    @Override
    public Question getRandomQuestion() {
        count = getCount();
        int index = 1; // итерации прохода по MAP
        int intRandom = getRandom(count); // случайное число
        log.info("intRandom" + intRandom);
        for (Question item : mathQuestionRepository.getAll()) {
            if (index == intRandom) {
                return item;
            }
            index += 1;
        }
        throw new QuestionNotExistException();
    }

    private int getRandom(int count) {
        int min = 1;
        return random.nextInt(count) + min;
    }

}