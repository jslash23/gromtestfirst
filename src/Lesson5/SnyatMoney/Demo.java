package Lesson5.SnyatMoney;

/**
 Напишите метод, который будет снимать деньги со
 счета определенного клиента и возвращать остаток на счете. Если денег на счете недостаточно
 метод будет возвращать -1.
 Сигнатура метода - withdraw(String[] clients, int[] balances, String client, int amount)
 Метод должен содержаться в классе. Название класса не важно*/

public class Demo {


    //ТЕСТИРОВАНИЕ
    //Обычная проверка +
    //Проверка если вводим клиента которого нет в списке +
    //Проверка на отрицательное значение снимаемой суммы +
    //Проверка на null выдает ошибку сделать чтоб выдовала сообщение

    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {  100,   500,    8332,    -99,       12000,    -54,      0};

        System.out.println(SnyatDeneg.withdraw(names, balances, "Ann", 400));
        System.out.println(SnyatDeneg.withdraw(names, balances, "Ahmed", 10));
        System.out.println(SnyatDeneg.withdraw(names, balances, "Denis", -100));
        //System.out.println(SnyatDeneg.withdraw(names, balances, null, -100));
    }

}
