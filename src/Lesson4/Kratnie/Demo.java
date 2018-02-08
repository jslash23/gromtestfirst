package Lesson4.Kratnie;

/**
 * Created by slash22 on 03.02.2018.
 */
//Выписываем кейсы как код можно использовать и когда он посыпется
    //Простое тестирование
    //С двумя отрицательными числами работает
    //Со всеми отрицательными числами работает
    //С одним налом вместо числа не работает
    //С конечным значением 0 работает
public class Demo {
    public static void main(String[] args) {
        System.out.println(ZadachaKratnie.findDivCount((short)2, (short)10, 2));//print 5
        System.out.println(ZadachaKratnie.findDivCount((short)-100, (short)-50, 2));
        System.out.println(ZadachaKratnie.findDivCount((short)-100, (short)-50, -2));
        System.out.println(ZadachaKratnie.findDivCount((short)10, (short)0, 2));

    }
}
