package Lesson16.HW16;

import java.util.Arrays;

/**
 * Created by slash22 on 07.04.2018.
 */
public class SolutionRepeatWord {
    public static void main(String[] args) {

        String text = " rtw# @ 2f74 @ slovon 37 slovon k 24 k 45r @ ";
        String text1 = "rtw#     @ 2f74   @ slovon 37     slovon k 24 k 45r @ ";
        String text2 = "  rtw#    null  @ 2f74    @ slovon 37  proverka   24  k 45r @ ";
        String text3 = "   100  300 500 ffjsfjsflj   ru   .. kyyu  ffjsfjsflj 464645 gggh ffjsfjsflj  ";

        System.out.println((mostCountedWord(text)));
        System.out.println((mostCountedWord(text1)));
        System.out.println((mostCountedWord(text2)));
        System.out.println((mostCountedWord(text3)));
    }

    public static String mostCountedWord(String input){

        if (input == null){
            return null; //Проверяем текст на налл
        }
        String[] words = input.trim().split(" ");

        if (words.length == 0){
            return null;
        }

        String repworld = null;
        //for(String word : words)


        for (int i = 0; i < words.length-1; i++ ) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].isEmpty() || words[j].isEmpty() ){
                    break;
                }
                if (words[i].equals(words[j]) && isSlovo(words[i]) && isSlovo(words[j])) {
                    repworld = words[i];
                    break;

                }//j++
            }//i++
        }
        return repworld;
    }

   static Boolean isSlovo(String words){
        if (!words.isEmpty() && words.matches("^[а-яА-ЯёЁa-zA-Z]+$") && words.length() > 0 ){
            return true;
        }
        return  false;
    }
}
