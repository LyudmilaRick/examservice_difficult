package pro.sky.java.course2.level2.examservice_difficult.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.level2.examservice_difficult.domain.Question;
import pro.sky.java.course2.level2.examservice_difficult.exeption.QuestionExistException;
import pro.sky.java.course2.level2.examservice_difficult.exeption.QuestionNotExistException;
import pro.sky.java.course2.level2.examservice_difficult.service.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository("javaRepository")
public class JavaQuestionRepository implements QuestionRepository {
    final Map<String, Question> examQuestion;
    int count = 0;
    /**
     * массив хэш значенийдля вопросов
     * простейшая проверка на дубликаты вопросов
     * отсечь варианты, отличающиеся знаками препинания
     */
    protected Set<Integer> hashForChecking;

    public JavaQuestionRepository() {
        this.examQuestion = new HashMap<>();
        this.hashForChecking = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        add("Полиморфизм", " это свойство, позволяющее " +
                "с помощью одного интерфейса обращаться к общему классу действий");
        add("Инкапсуляция", " разграничение доступа к данным и возможностям классов и объектов");
        add("Наследование", " это процесс, в ходе которого один объект приобретает свойства другого объекта");
        add("Массив", "это упорядоченная структура данных фиксированного размера.");
        add("Switch", "это переключатель, который обеспечивает многовариантное ветвление программы.");
    }

    @Override
    public Question add(String question, String answer) {
        Question item = new Question(question, answer);
        return add(item);
    }

    @Override
    public Question add(Question question) {
        if (collectHash(question.getQuestion())) {
            examQuestion.put(question.getQuestion(), question);
            count++;
            return question;
        }
        throw new QuestionExistException();
    }

    @Override
    public Question remove(Question question) {
        if (examQuestion.containsKey(question.getQuestion())) {
            count--;
            return examQuestion.remove(question.getQuestion());
        }
        throw new QuestionNotExistException();
    }

    @Override
    public Collection<Question> getAll() {
        return Map.copyOf(examQuestion).values();
    }

    @Override
    public int getCount() {
        return count;
    }

    private boolean collectHash(String question) {
        int hashValue = getStringHash(question);
        if (hashForChecking.contains(hashValue)) {
            return false;
        }
        hashForChecking.add(getStringHash(question));
        return true;
    }

    private int getStringHash(String string) {
        String[] listFromString = string.split(" ,.");
        for (String item : listFromString) {
            item.toLowerCase();
            item.replace(" ", "");
        }
        String newString = Arrays.toString(listFromString);
        return newString.hashCode();
    }

}
