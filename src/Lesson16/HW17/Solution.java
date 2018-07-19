package Lesson16.HW17;

import java.util.Arrays;
//написать метод countWords для подсчета слов во входящем стринге. Под словом имеется ввиду текст разделенный пробелом
//(без спецсимволов).Название класса Solution.

public class Solution {
    //АЛГОРИТМ
    //Считаем количество входных слов разделенных пробелом

    public static void main(String[] args) {
        String text = " *test e232 rrre555 &яфуиш  ?принимает задачу  ";
        System.out.println(countWords(text));
        String text1 = "";
        System.out.println(countWords(text1));
        System.out.println(countWords(null));

    }
    private static int countWords(String input) {
        if (input == null || input.isEmpty())
            return 0;
        int count = 0;
        String[] words = input.split(" ");
        for (String word: words) {
            if (!word.isEmpty() && (word.matches("^[а-яА-ЯёЁa-zA-Z]+$")))
              count++;
            }
        return count;
    }
}
