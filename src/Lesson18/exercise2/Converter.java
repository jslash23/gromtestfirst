package Lesson18.exercise2;

/**
 * Created by slash22 on 27.04.2018.
 */
public class Converter {
    public static void main(String[] args) {
        System.out.println(intToString(111231));
        System.out.println(stringToInt("11"));

        System.out.println(stringToInt("1050a"));
    }


    public static String intToString (int input) {
        return String.valueOf(input);// метод из разных типов делает Стринг
    }

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);//метод класса Integer принимает Стринг
            // и воозвращает Инт

        } catch (NumberFormatException e) {
            System.out.println(input + " can not be converted to int");
            return 0;
        }
    }
}
