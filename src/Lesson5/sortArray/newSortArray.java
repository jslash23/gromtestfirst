package Lesson5.sortArray;

import java.util.Arrays;

/**Напишите два метода, которые будут сортировать массив в порядке возрастания и убывания соответственно.
Возвращаемое значение - отсортированный массив

Сигнатура методов:
int[] array sortAscending(int[] array)
int[] array sortDescending(int[] array)

Методы должны находиться в классе, название класса не важно*/

//ТЕСТИРОВАНИЕ
    //Здесь используется простое тестирование

public class newSortArray {


    static int[] sortAscending(int[] array) {//Вывод по возрастанию
        int max = array[0];
        int count = 0;
        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j]  > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            count++;
        }
        int[] newarr = new int[count];

        int index = 0;
        int resIndex = 0;

        for (int i = 0; i < array.length; i++) {
            newarr[resIndex] = array[index];
            resIndex++;
            index++;
        }
        return newarr;
    }

    static int[] sortDescending(int[] array) {//Вывод по убыванию

        int max = array[0];
        int count = 0;
        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            count++;
        }
        int[] newarr = new int[count];

        int index = 0;
        int resIndex = 0;


        for (int i = 0; i < array.length; i++) {
            newarr[resIndex] = array[index];
            resIndex++;
            index++;
        }
        return newarr;
    }
}









