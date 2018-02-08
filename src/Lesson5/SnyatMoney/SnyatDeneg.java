package Lesson5.SnyatMoney;


/**Вернемся к примеру с клиентами и счетами. Напишите метод, который будет снимать деньги со
счета определенного клиента и возвращать остаток на счете. Если денег на счете недостаточно
метод будет возвращать -1.
Сигнатура метода - withdraw(String[] clients, int[] balances, String client, int amount)
Метод должен содержаться в классе. Название класса не важно*/

//ПРИМЕР С БАНКОВСКИМИ СЧЕТАМИ
//- Пополнение баланса (с комиссией);
// <= 100 2%
// > 100  1%

//- Снятие баланса
//У каждого клиента есть имя и баланс счета 1000 едениц денег,



public class SnyatDeneg {


    public static int withdraw(String[] clients, int[] balances, String client, int ammount) {
        int index = 0;
        int res;

       /* int count = 0;
        boolean flag = true;
        int temp;*/

    //Ищем индекс нашего клиента
        for (String cl : clients) {
            if ((cl == client) & (ammount > 0)) {
            break;
            }
            if ((cl == null) || (ammount == 0)){

                res = -1;
                return res;
            }
            if ((cl.compareTo(client) != 0) & (index == clients.length - 1)) {//если двойной & и
                // перв. выраж. ложно, то второе выражение не будет проверятся
                  res = -1;
                  return res;
             }
          index++;
        }

            if (balances[index] >= ammount) {
                balances[index] -= ammount;
                res = balances[index];
            } else res = -1;
            return res;
        }
    }

