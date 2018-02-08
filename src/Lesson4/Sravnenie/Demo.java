package Lesson4.Sravnenie;

//Выписываем кейсы как код можно использовать и когда он посыпется
    //Огромные числа +
    //Если все отрицательные числа не работает
    //Если хотя бы вместо одного числа налл то программа ругается
    //От одного до такого же числа

public class Demo {
    public static void main(String[] args) {
        System.out.println(ZadachaSravnenieSumi.compareSums(2, 20, 10, 20));
        System.out.println(ZadachaSravnenieSumi.compareSums(1555, 2065478945, 10524789, 254547890));
        System.out.println(ZadachaSravnenieSumi.compareSums(-49, -200, -10, -57));
        System.out.println(ZadachaSravnenieSumi.compareSums(-500, 0, 10, 10));
    }
}
