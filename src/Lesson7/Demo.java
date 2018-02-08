package Lesson7;

import Lesson6.Order;
import java.util.Date;

/**
 * Created by slash22 on 29.10.2017.
 */
public class Demo{
    public static void main(String[] args){


        //ТЕСТИРОВАНИЕ
        //Простое тестирование +
        //Тестирование с проверкой правильно введенных данных -
        //если в дате все налы то работает, если сверяем с текущими датами то не работает

        //Order ordObj = new Order(100, new Date(), false, new Date(), "Dnepr", "Ukraine", "Buy");

        //Order ordObj = new Order(100, new Date(), false, null, "Dnepr",
               // "Ukraine", "Buy");

        System.out.println(OrderClass.createOrder());
        System.out.println(OrderClass.createOrderAndCallMethods());
    }
}
