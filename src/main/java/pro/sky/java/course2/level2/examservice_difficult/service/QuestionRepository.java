package pro.sky.java.course2.level2.examservice_difficult.service;

import pro.sky.java.course2.level2.examservice_difficult.domain.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    int getCount();

}

