package Lesson20.task.exception;

/**
 * Created by slash22 on 29.06.2018.
 */
public class InternalServelException extends Exception {//Внутреняя ошибка сервера
    public InternalServelException(String message) {
        super(message);
    }
}
