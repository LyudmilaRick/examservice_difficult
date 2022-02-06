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

@Service("javaService")
public class JavaQuestionService implements QuestionService {
    private static final Logger Log = LoggerFactory.getLogger(MathQuestionService.class);
    private final QuestionRepository javaQuestionRepository;
    int count = 0;

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
        int index = 1; // итерации прохода по MAP
        int intRandom = getRandom(count); // случайное число
        Log.info("intRandom" + intRandom);
        for (Question item : javaQuestionRepository.getAll()) {
            if (index == intRandom) {
                return item;
            }
            index += 1;
        }
        throw new QuestionNotExistException();
    }

    private int getRandom(int count) {
        java.util.Random random = new java.util.Random();
        int min = 1;
        return random.nextInt(count) + min;
    }
}
