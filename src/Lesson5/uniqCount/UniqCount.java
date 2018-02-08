package Lesson5.uniqCount;
import java.util.Arrays;

/**НАХОЖДЕНИЕ УНИКАЛЬНЫХ
Напишите метод uniqueCount, который будет находить количество уникальных чисел в массиве.Если число
 повторяется больше одного раза, то его стоит учитывать, но только один раз.Длина массива > 0

Сигнатура метода - uniqueCount(int[] array)
Метод должен содержаться в классе. Название класса не важно

Пример:
Входящие данные
{11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11}
Ответ 7
Объяснение:
Массив без повторений будет выглядеть
4, 5, 10, 11, 12, 44, 100 - длинна 7
Числа 10, 11, 44 повторяются больше одного раза, но в ответе они учитываются один раз*/

public class UniqCount {
    public static int uniqueCount(int[] array) {
        int count = 0;
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++)
            if (i != array.length - 1) {
                if (array[i] != array[i + 1])
                    count++;
            }
        return count == 0 ? count  : count + 1 ;
    }
}











