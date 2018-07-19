package Lesson16;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by slash22 on 23.03.2018.
 */
public class StringMethods {
    public static void main(String[] args) {
        String test = "someStringExample";
        System.out.println(test.isEmpty()); //return tru or false
        System.out.println("".isEmpty());
        System.out.println(test.length());//length of string
        System.out.println(test.charAt(2));//find konkretniy char who situated on position

        String res = test.replace("me", "T");//меняет целевой символ на заданный
        System.out.println(res);

        System.out.println(test.replaceAll("me","T"));//проверяет валидацию по формату
        //String regex = {a-Z};
        System.out.println(test);
        System.out.println(test.contains("mes"));//метод проверяет содержит ли стринг какуе-то
        //последовательность чаров. метод возвращает тру для него есть разница по буквам верхний регистр или нижний

        System.out.println(test);
        String phrase = "Hello there guys";

        System.out.println(Arrays.toString(phrase.split(" ")));//"Этот метод делит на подстринги
        // по пробелам возвращает подстринги но удаляет букву по которой делим стринги

        System.out.println("   test a".trim());//удаляет пробелы в начале и в конце нашего стринга
        //метод substring возвращает стринг который является подстрингом нашего стринга

        System.out.println(phrase.substring(5));// начало стринга с 5 позиции
        System.out.println(phrase.substring(5,10).trim());//пятый включительно и 10 не включительно
        System.out.println(test.toUpperCase());//все буквы стали большими
        System.out.println(test.toLowerCase());

        test.getBytes();
        test.equals("eeee");
        test.intern();
    }
}
