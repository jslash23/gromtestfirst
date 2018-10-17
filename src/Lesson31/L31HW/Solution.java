package Lesson31.L31HW;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    public static Map<Character, Integer> countSymbols(String text) {
        Map<Character, Integer> result = new LinkedHashMap<>();

        if (text != null) {
            char[] chars = text.toCharArray();

            int count = 0;
            for (char s : chars) {
                for (char sArray : chars) {
                    if (s == sArray) {
                        count++;
                    }
                }
                if (s != 32) result.put(s, count);
                count = 0;
            }
        }
        return result;
    }

    public static Map<String, Integer> words(String text) {
        Map<String, Integer> res = new LinkedHashMap<>();

        if (text != null) {

            String[] words = text.split(" ");

            int count = 0;
            for (String Word : words) {
                if (Word.length() < 2) {
                    words[count] = null;
                }
                count++;
            }

            count = 0;
            for (String Word : words) {
                for (String WordArray : words) {
                    if (Word != null && WordArray != null) {
                        if (Word.equalsIgnoreCase(WordArray)) {
                            count++;

                        }
                    }
                }
                if (Word != null) res.put(Word, count);
                count = 0;
            }
        }
        return res;
    }
}
