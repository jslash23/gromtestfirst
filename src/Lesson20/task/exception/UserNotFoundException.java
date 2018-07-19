package Lesson20.task.exception;

/**
 * Created by slash22 on 29.06.2018.
 */
public class UserNotFoundException extends Exception {//Ошибка неправильных данных

    public UserNotFoundException(String message) {
        super(message);
    }
}
