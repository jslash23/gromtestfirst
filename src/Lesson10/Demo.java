package Lesson10;

import java.util.Date;

/**
 Абстрактный ордер

 Необходимо реализовать  иерархию Order  классов в условном интернет
 магазине.
 Корневым классом в иерархии будет Order с полями:

 String itemName
 Date dateCreated
 Date dateConfirmed
 Date dateShipped
 Strings hipFromCity
 Strings hipToCity
 int basePrice
 double totalPrice
 Customer customerOwned

 Конструктор которого содержит все поля класса кроме
 dateConfirmed
 dateShipped
 totalPrice

 У класса есть методы без реализации:
 void validateOrder()
 void calculatePrice()

 А так же обычный метод
 void confirmShipping()

 Который проставляет дату доставки в текущую, если она еще не проставлена

 Все поля открыты для чтения и три поля открыты для модификации
 dateShipped
 dateConfirmed
 totalPrice

 Класс Customer описывает клиента который производит заказ
 Его поля:
 String name
 String sity
 String gender(Допустимые значения мужской,женский.Валидировать это не надо, гарантируется что значения
 тут правильные)
 Для создания клиента следует указать все его поля.Следуйте инкапсуляции, поля класса должны быть доступны
 только на чтение

 Класс ElectronicsOrder описывает заказы электроники. У него есть дополнительное поле
 int guaranteeMonths
 Класс реализовывает абстрактные методы по правилам:
    Валидация
 Заказ возможен с городов: Киев, Одесса, Днепр, Харьков и в один из этих городов. Минимальная цена заказа 100.
 Так же имя клиента который делает заказ может быть любым а пол только женский.
 Расчет цены
 Цена может состоять из цены товара и цены за доставку. Так же могут быть скидки.Если доставка производится
 в любой город кроме Киева и Одессы, то цена за доставку – 15% от сумы заказа. В других случаях 10%.
 Так же если цена больше 1000 то скидка  на заказ 5% после оплаты комиссии за доставку.
 Класс FurnitureOrder описывает заказы мебели. У него есть дополнительное поле String furnitureCode.
 Класс реализовывает абстрактные методы по правилам
    Валидация
 Заказ возможен с городов: Киев, Львов и в любой город. Минимальная цена заказа 500.Так же имя клиента
 который делает заказ не может быть “Тест”,  а пол может быть любым.
 Расчет цены
 Комиссия за доставку - 5% от суммы заказа если сумма меньше 5000 и 2% в других случаях.
 В классе Demo в main методе создайте по 2 объектакаждого из классовOrder. Вызовите у них все 3 метода в
 правильной очередности.
*/

public class Demo {

    //ТЕСТИРОВАНИЕ
    //Простое тестирование  electronicsOrder0 +
    //Тестирование с минусовой ценой electronicsOrder0 +
    //Тестирование с минусовой ценой furnitureOrder0 +
    //Тестирование с мужским полом  furnitureOrder0 item name "Test" +

    public static void main(String[] args) {
        ElectronicsOrder electronicsOrder0 = new ElectronicsOrder("Komputer", new Date(),
                "Львов", 500, new Customer("Василий", "Киев", "мужской"),
                10);

        ElectronicsOrder electronicsOrder = new ElectronicsOrder("Komputer", new Date(),
            "Львов", -100, new Customer("Василий", "Киев", "мужской"),
            10);

        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("Monitior", new Date(),
            "Киев", 200, new Customer("Диана", "Харьков", "женский"),
            5);

        FurnitureOrder furnitureOrder0 = new FurnitureOrder("Test", null, "Киев",
            200, new Customer("Тарас", "Днепр", "мужской"), "table");

        FurnitureOrder furnitureOrder = new FurnitureOrder("Стол", null, "Киев",
                -200, new Customer("Тарас", "Днепр", "мужской"), "table");

        FurnitureOrder furnitureOrder1 = new FurnitureOrder("Кресло", null,
            "Харьков", 1000, new Customer(null, null, "мужской"),
            "chear");

        ElectronicsOrder[] electronicsOrders = new ElectronicsOrder[]{electronicsOrder0,electronicsOrder,
                electronicsOrder1};
        FurnitureOrder[] furnitureOrders = new FurnitureOrder[]{furnitureOrder0,furnitureOrder,furnitureOrder1};

        for (Order order:electronicsOrders) {

            order.calculatePrice();
            order.confirmShipping();
            order.validateOrder();
        }
        for (Order order:furnitureOrders) {

            order.calculatePrice();
            order.confirmShipping();
            order.validateOrder();
        }
    }
}

