package pro.sky.java.course2.level2.examservice_difficult.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);

    }

    public BadRequestException() {
        super("Неверный запрос количества вопросов");
    }
}
