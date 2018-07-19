package Lesson18;

public class Solution {
    public static void main(String[] args) {
        findNumbers(null);
        findNumbers("");
        findNumbers("huyak || 148teyet 54ret 78 27k jb3 9 quest && ?? .... www.test ");
        findNumbers("148teyet 54ret 25 27k jb3 7 quest //");
    }

    public static int findNumbers(String text) {

        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] Words = text.trim().split(" ");

        for (String w : Words) {

            if (w.matches("^[0-9]+$")) {
                Integer.parseInt(w);// конвертим Стринг в Инт
                System.out.println(w);

            } else System.err.println(w + " not a number");
        }
        return 0;
    }
}
