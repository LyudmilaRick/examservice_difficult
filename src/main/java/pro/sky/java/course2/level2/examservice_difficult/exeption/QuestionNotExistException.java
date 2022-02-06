package pro.sky.java.course2.level2.examservice_difficult.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class QuestionNotExistException extends RuntimeException {
    public QuestionNotExistException(String message) {
        super(message);
    }

    public QuestionNotExistException() {
        super("Вопрос в такой постановке ранее не сохранялся");
    }
}

