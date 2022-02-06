package pro.sky.java.course2.level2.examservice_difficult.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class QuestionExistException extends RuntimeException {
    public QuestionExistException(String message) {
        super(message);
    }

    public QuestionExistException() {
        super("Вопрос в сервисе уже существует!");
    }
}