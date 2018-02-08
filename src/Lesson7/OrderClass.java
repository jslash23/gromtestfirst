package Lesson7;

import Lesson6.Order;

import java.util.Date;

/**
 * Created by slash22 on 01.07.2017.
 */

/**
 * ОБЪЕКТЫ ОРДЕР КЛАССА
 * <p>
 * В классе OrderClass создайте два метода:
 * -createOrder()
 * -createOrderAndCallMethods()
 * <p>
 * Первый метод должен возвращать объект класса Order с предыдущего ДЗ созданного с параметрами
 * price = 100, dateCreated = текущая, isConfirmed = false, dateConfirmed = null, city = "Dnepr",
 * country = "Ukraine", type = "Buy"
 * <p>
 * Второй метод должен создавать объект с другими параметрами
 * price = 100, dateCreated = текущая, isConfirmed = true, dateConfirmed = текущая, city = "Kiev",
 * country = "Ukraine", type = "SomeValue"
 * Вызываете все методы с класса Order через его объект и возвращаете объект
 */

public class OrderClass {

    public static Order createOrder() {//Возвращаем объект //static используем для работы с майн методом
        Order ordObj = new Order(100, new Date(), false, null, "Dnepr",
                "Ukraine", "Buy");
        Order ordObj1 = new Order(-100, new Date(), false, null, "Dnepr",
                "Ukraine", "Buy");

        Order[] ordersCr = new Order[]{ordObj,ordObj1};

        for (Order orderses:ordersCr) {
            if (orderses.getPrice() == 100 && orderses.getDateCreated() == new Date() &&
               orderses.isConfirmed() == false && orderses.getDateConfirmed() == null && orderses.getCity()
               == "Dnepr" &&orderses.getCountry() == "Ukraine" && orderses.getType() == "Buy")

                return orderses;
        }
            return null;
    }

    public static Order createOrderAndCallMethods() {
        Order orderObject = new Order(100, new Date(), true, new Date(), "Kiev",
                "Ukraine", "SomeValue");
        Order orderObject1 = new Order(-200, new Date(), true, new Date(), "Kiev",
                "Ukraine", "SomeValue");

        Order[] orders = new Order[]{orderObject, orderObject1};

        for (Order ordersnew : orders) {
            if (ordersnew.getPrice() == 100 && ordersnew.getDateCreated() == new Date() &&
                    ordersnew.isConfirmed() == true && ordersnew.getDateConfirmed() == new Date() &&
                    ordersnew.getCity() == "Kiev" && ordersnew.getCountry() == "Ukraine" &&
                    ordersnew.getType() == "SomeValue")

            ordersnew.checkPrice();
            ordersnew.confirmOrder();
            ordersnew.isValidType();
            return ordersnew;
        }
        return null;
    }
}

