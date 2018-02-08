package Lesson8.Arithmetic;
/**
Напишите класс Arithmetic с методом check, который принимает массив, как параметр и возвращает true
 если сумма его максимального и минимального элемента > 100, false в другом случае
Напишите другой класс Adder, который наследуется от Arithmetic. Класс Adder содержит метод add,
который принимает два параметра и возвращает их сумму
Создайте класс демо, где в main методе через объект класса Adder вы вызовите два этих метода
 Сигнатура методов:
        check(int[] array)
        add(int a, int b)
 */

public class Demo  {

    public static void main(String[] args){

        Adder adder = new Adder();

        //ТЕСТИРОВАНИЕ
        //Простое тестирование +
        //Тестирование если в массиве все 0 +
        //Тестирование если в методе adder нули 0


        int[] array = {-10, 0, 110, 555, 1000, -45, 0, 60, 10};
        int[] array1 = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println(Arithmetic.maxElement(array));
        System.out.println(Arithmetic.minElement(array));
        System.out.println(adder.add(5, 7));
        System.out.println(Arithmetic.check(array));
        System.out.println("");

        System.out.println(Arithmetic.maxElement(array1));
        System.out.println(Arithmetic.minElement(array1));
        System.out.println(adder.add(-5, -500));
        System.out.println(adder.add(0, 0));
        System.out.println(Arithmetic.check(array1));
    }
}
