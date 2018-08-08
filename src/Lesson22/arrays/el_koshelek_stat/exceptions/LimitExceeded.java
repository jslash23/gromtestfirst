package Lesson22.arrays.el_koshelek_stat.exceptions;


public class LimitExceeded extends BadRequestException {
    public LimitExceeded(String message) {
        super(message);
    }
}
