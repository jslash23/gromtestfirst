package Lesson17;

import java.util.Arrays;

/**
 * Created by slash22 on 29.03.2018.
 */
public class Exercises {

    public static void main(String[] args) {
        String test = "There is Test something new or jot sdf sdf sdf word Test op or";
        System.out.println(deleteDuplicates(test));
        System.out.println(Arrays.toString(countDuplicates(test,new String[]{"or","some","test"})));
    }

    //delete replacing words
    public static String deleteDuplicates(String input){//тут нам нужно удалить слова, повторяющиеся в стринге

        //АЛГОРИТМ:
        //Найти повторения
        //И удалить их

        String[] words = input.split(" ");

        for ( int i = 0; i < words.length; i++ ){//
           for ( int j =  i + 1; j < words.length; j++){
                if (words[i].equals(words[j]))
                    words[j] = "";
           }
        }

        String res = " ";
        for (String word : words) {
            res += word;
            if (!word.isEmpty())//после удаления слов дубликатов остаются пустые стринги нам не нужно
                res += " ";//двойных пробелов если стринги не пустые то прибавляй, иначе не нужно прибавлять
        }
        return  res;
        }

    //count Duplicates //на вход заходит стрингов а на выходе массив коунтов
     public static int[] countDuplicates(String input, String[] words){
        String[] strings = input.split(" ");//разбиваем стринг на слова

        int[] res = new int[words.length];//создание массива с длиной такой же как и входной массив
         //каждое слово текста(string) проверяем со словами которые у нас на входе(words) в задаче
         //и если есть совпадения то увеличиваем число вхождений этого слова на 1
         for (String string: strings) {
             for (int i = 0; i < words.length; i++) {
                 if (string.equals(words[i]))
                     res[i]++;
             }
         }
        return  res;
    }

    String replace(String input, String target, String raplacement){
        return  null;
    }
}
