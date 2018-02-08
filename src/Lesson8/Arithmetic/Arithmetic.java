package Lesson8.Arithmetic;

public class Arithmetic {

    public static boolean check(int[] array) {

        if ((maxElement(array) + minElement(array)) > 100) {

            return true;
        }
        return false;
    }

    public static int maxElement(int[] array) {// объявили static чтоб можно было использовать в maine
        int max = array[0];

        for (int el : array) {
            if (el > max)
                max = el;
        }
        return max;
    }

    public static int minElement(int[] array) {// объявили static чтоб можно было использовать в maine
        int min = array[0];

        for (int el : array) {
            if (el < min)
                min = el;
        }
        return min;
    }
}


