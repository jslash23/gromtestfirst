package Lesson20.NewTask.exceptions;


public class LimitExceeded extends BadRequestException {
    public LimitExceeded(String message) {
        super(message);
    }
}
