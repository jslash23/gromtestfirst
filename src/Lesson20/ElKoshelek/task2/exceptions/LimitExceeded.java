package Lesson20.ElKoshelek.task2.exceptions;


public class LimitExceeded extends BadRequestException {
    public LimitExceeded(String message) {
        super(message);
    }
}
