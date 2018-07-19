package Lesson16;

/**
 * Created by slash22 on 22.03.2018.
 */
public class StringUsage {
    public static void main(String[] args) {
        String test = "someString";
        String result = test + "_end";
        System.out.println(result);

        //String это массив чаров
        char charVarable = 't';
        char charVarable1 = 'o';
        char[] chars = new char[]{charVarable,charVarable1};
        String test1 = new String(chars);

        System.out.println(test1);

        String test2 = new String("hello there");
        System.out.println(test2);
    }
}
