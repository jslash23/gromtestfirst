package Lesson6;

import java.util.Arrays;

/**СОЗДАНИЕ СВОЕГО КЛАССА
 Представьте что вы разрабатываете ресурс, где люди могут заключать сделки по продаже-покупке недвижимости.
 Для такого ресурса нужно будет создать сущность (класс) Order, которая будет отображать и хранить
 данные о сделках. Создайте этот класс и добавьте в него следующее.

 Поля:
 long id
 int price
 Date dateCreated
 boolean isConfirmed
 Date dateConfirmed
 String city
 String country
 String type

 Создайте два конструктора:
 1) который будет использовать все поля, кроме id
 2) пустой

 Создайте методы:
 confirmOrder() - должен проставлять ордер в статус confirmed = true и дату конфирма ставить в текущую
 checkPrice() - должен возвращать true если цена сделки больше 1000 и false в другом случае
 isValidType() - type поле может принимать только два значения - Buy, Sale - метод возвращает
 true если это требование выполняется и false если нет
 */

public class Demo {
    public static void main(String[] args) {

        //Тестирование
        //Обычные параметры +
        //Цена отрицательная +
        //Ноль и все налы +

        Order order1 = new Order(10000,null,false,null,
                "Yalta","Ukraine","Sale");

        Order order2 = new Order(-100,null,false,null,
                "Kiev","Ukraine","Buy");

        Order order3 = new Order(0,null,false,null,
                null,null,null);


        Order[] orders = new Order[]{order1,order2,order3};

        for (Order ord: orders) {
            ord.confirmOrder();
            ord.checkPrice();
            ord.isValidType();
        }
        System.out.println(Arrays.deepToString(orders));
    }
}
