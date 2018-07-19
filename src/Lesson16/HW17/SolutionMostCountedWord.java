package Lesson16.HW17;

/**
 * Created by slash22 on 10.04.2018.
 */
public class SolutionMostCountedWord {
    //Найдем наиболее повторяемые слова в массиве слов
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

    public static String mostCountedWord (String input){

        if (input.isEmpty()) {
            return null;
        }

        String[] words = input.split(" ");
        //Для того чтоб найти наиболее повторяемое слово в массиве слов
        //мы создали счетчик
        int maxCount = 0;
        String mostFrequent = null;
        for (String word : words) {
            int count = 0;
            for (String item : words) {
                if (word.equals(item) && word.length() > 0 && (isWord(word)))
                    count++;

            if (count > maxCount){
                maxCount = count;
                mostFrequent = word;

            }
          }
        }
        return mostFrequent;
    }
    static Boolean isWord(String words){
        if (!words.isEmpty() && words.matches("^[а-яА-ЯёЁa-zA-Z]+$")  ){
            return true;
        }
        return  false;
    }
}
