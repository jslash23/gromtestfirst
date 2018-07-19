package Lesson20.task.exception;

/**
 * Created by slash22 on 29.06.2018.
 */
public class Test {
    public static void main(String[] args) throws Exception {

        int a = 10;
        if (a > 5)
            throw new BadRequestException("error");

    }
}
