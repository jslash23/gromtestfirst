package Lesson5.uniqCount;

/**НАХОЖДЕНИЕ УНИКАЛЬНЫХ
 Напишите метод uniqueCount, который будет находить количество уникальных чисел в массиве.Если число
 повторяется больше одного раза, то его стоит учитывать, но только один раз.Длина массива > 0

 Сигнатура метода - uniqueCount(int[] array)
 Метод должен содержаться в классе. Название класса не важно

 Пример:
 Входящие данные
 {11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11}
 Ответ 7
 Объяснение
 Массив без повторений будет выглядеть
 4, 5, 10, 11, 12, 44, 100 - длинна 7
 Числа 10, 11, 44 повторяются больше одного раза, но в ответе они учитываются один раз
 */
public class Demo {
    public static void main(String[] args) {
        int[] array0 = {11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11};
        int[] array1 = {-11, 12, -10, 5, 4, 44, 100, -44, 11, 10, 11};
        int[] array2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] array3 = {-100, -11, -15, -11, -90, -1000, -11520, -110, -10, -352, -58697};
        int[] array4 = {50, 800, 90, 5, 80, 15896, 45, 57, 54, 1564640, 9785,4564, 45, 99,789,-100000,1000000000};

        //ТЕСТИРОВАНИЕ
        //простое тестирование +
        //тестирование если все отрицательные +
        //тестирование если все числа одинаковые +

        System.out.println(UniqCount.uniqueCount(array0));

        System.out.println(UniqCount.uniqueCount(array1));

        System.out.println(UniqCount.uniqueCount(array2));
        // System.out.println(Arrays.toString(removeDuplicates(array)));

        System.out.println(UniqCount.uniqueCount(array3));

        System.out.println(UniqCount.uniqueCount(array4));
    }

}
