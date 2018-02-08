package Lesson6;

import java.util.Date;

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
isValidType() - type поле может принимать только два значения - Buy, Sale. Метод возвращает
true если это требование выполняется и false если нет
 */

public class Order {

    long id;
    int price;
    Date dateCreated;
    boolean isConfirmed;
    Date dateConfirmed;
    String city;
    String country;
    String type;

    public Order() {
    }

    Order[] order = new Order[1];

     public Order(int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed,
                 String city, String country, String type) {
        this.price = price;
        this.dateCreated = dateCreated;
        this.isConfirmed = isConfirmed;
        this.dateConfirmed = dateConfirmed;
        this.city = city;
        this.country = country;
        this.type = type;
    }

    boolean confirmOrder;
    boolean checkPrice;
    boolean isValidType;

    public Order(boolean confirmOrder, boolean checkPrice, boolean isValidType) {
        this.confirmOrder = confirmOrder;
        this.checkPrice = checkPrice;
        this.isValidType = isValidType;
    }

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public Date getDateConfirmed() {
        return dateConfirmed;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getType() {
        return type;
    }

    public boolean isConfirmOrder() {
        return confirmOrder;
    }

    public boolean isCheckPrice() {
        return checkPrice;
    }

    public void confirmOrder() {
        if (isConfirmed != true) {
            dateConfirmed = new Date();
            isConfirmed = true;
        }
    }

    public boolean checkPrice() {
        if (price > 1000) {
            return true;
        }
        return false;
    }

    public boolean isValidType() {

        if (type == "Buy" | type == "Sale") {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", dateCreated=" + dateCreated +
                ", isConfirmed=" + isConfirmed +
                ", dateConfirmed=" + dateConfirmed +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                ", confirmOrder=" + confirmOrder +
                ", checkPrice=" + checkPrice +
                ", isValidType=" + isValidType +
                '}';
    }
}


