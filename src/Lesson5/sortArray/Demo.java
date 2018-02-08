package Lesson5.sortArray;

import java.util.Arrays;

/**Напишите два метода, которые будут сортировать массив в порядке возрастания и убывания соответственно.
 Возвращаемое значение - отсортированный массив

 Сигнатура методов:
 int[] array sortAscending(int[] array)
 int[] array sortDescending(int[] array)

 Методы должны находиться в классе, название класса не важно*/

public class Demo {
    public static void main(String[] args) {

        //ТЕСТИРОВАНИЕ
        //Простое тестирование +
        //Если все числа в массиве отрицательные: показывает в обратном порядке
        //Если в массиве все нули +

        int[] array = {1, 4, 2, 12, 100, 5, 8};
        int[] array1 = {-10000000, -250, -325087541, -0, -10, -25, -70};
        int[] array2 = {0, -0, 0, -0, 0, 0, 0};

        System.out.println(Arrays.toString(newSortArray.sortAscending(array)));
        System.out.println(Arrays.toString(newSortArray.sortDescending(array)));

        System.out.println(Arrays.toString(newSortArray.sortAscending(array1)));
        System.out.println(Arrays.toString(newSortArray.sortDescending(array1)));

        System.out.println(Arrays.toString(newSortArray.sortAscending(array2)));
        System.out.println(Arrays.toString(newSortArray.sortDescending(array2)));

    }
}
