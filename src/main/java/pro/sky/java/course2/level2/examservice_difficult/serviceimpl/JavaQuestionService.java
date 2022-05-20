package pro.sky.java.course2.level2.examservice_difficult.serviceimpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.level2.examservice_difficult.domain.Question;
import pro.sky.java.course2.level2.examservice_difficult.exeption.QuestionNotExistException;
import pro.sky.java.course2.level2.examservice_difficult.service.QuestionRepository;
import pro.sky.java.course2.level2.examservice_difficult.service.QuestionService;

import java.util.*;

@Service("javaService")
public class JavaQuestionService implements QuestionService {
    private static final Logger log = LoggerFactory.getLogger(JavaQuestionService.class);
    private final QuestionRepository javaQuestionRepository;
    private int count = 0;
    private Random random = new Random();

    public JavaQuestionService(@Qualifier("javaRepository") QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return javaQuestionRepository.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public int getCount() {
        return javaQuestionRepository.getCount();
    }

    @Override
    public Question getRandomQuestion() {
        count = getCount();
        int intRandom = getRandom(count); // случайное число
        return javaQuestionRepository.getAll().stream()
                .skip(intRandom - 1)
                .findFirst()
                .orElseThrow(() -> new QuestionNotExistException());
    }

    private int getRandom(int count) {
        int min = 1;
        return random.nextInt(count) + min;
    }
}
