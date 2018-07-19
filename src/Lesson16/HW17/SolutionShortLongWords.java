package Lesson16.HW17;

public class SolutionShortLongWords {
    /*Напишите методы для поиска самого длинного и самого короткого слова во входящем стринге
    maxWord(String input);
    minWord(String input);

    Если есть несколько таких слов выводите произвольное.
    Название класса Solution*/
    public static void main(String[] args) {
        String text = "  43g test e232 rrre555 &яфуиш что за нафиг ?почему мегасловище  код не принимает задачу *ау ";
        String text1 = "";
        String text2 = null;
        String text3 = "  25t u pr @ dh  leto* proverka  zima7 osen& megaslovo sl@ megaslovishe";

        System.out.println(maxWord(text));
        System.out.println(minWord(text));

        System.out.println(maxWord(text1));
        System.out.println(minWord(text1));

        System.out.println(maxWord(text2));
        System.out.println(minWord(text2));

        System.out.println(maxWord(text3));
        System.out.println(minWord(text3));
    }
    //АЛГОРИТМ
    //Разделяем наш входной стринг на подстринги
    //Находим самый длинный подстринг и самый короткий

    static String maxWord(String input) {

        if (input == null || input.isEmpty())
            return null;

        String[] words = input.trim().split(" ");

        String max = words[0];

        for (int k = 0; k < words.length - 1; k++) {

            //если слово  не содержит набор из букв и цифр и не пустое то далее
            if (!words[k].isEmpty() && (!words[k].matches("^[а-яА-ЯёЁa-zA-Z0-9]+$")))
                if ((words[k + 1].length()) > max.length())
                    max = words[k + 1];
        }
        return max;
    }

    static String minWord(String input) {

        if (input == null || input.isEmpty())
            return null;

        String[] words = input.trim().split(" ");

        String min = words[0];

        for (int k = 0; k < words.length - 1; k++) {
            if (!words[k].contains("") && (!words[k].matches("^[а-яА-ЯёЁa-zA-Z0-9]+$"))
                    && !words[k].isEmpty())
                continue;
            if (words[k + 1].length() < min.length() && !words[k + 1].isEmpty()){
                min = words[k + 1];
            }
        }
        return min;
    }

}


