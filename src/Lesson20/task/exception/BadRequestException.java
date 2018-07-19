package Lesson20.task.exception;

/**
 * Created by slash22 on 29.06.2018.
 */
public class BadRequestException extends Exception {//Ошибка ввода неправильных данных

    public BadRequestException(String message) {
        super(message);
    }
}
