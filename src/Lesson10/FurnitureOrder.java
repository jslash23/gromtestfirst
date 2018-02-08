package Lesson10;

import java.util.Date;

public class FurnitureOrder extends Order {
    String[] shipFromCity = {"Киев","Львов"};

    String furnitureOrder;

    public FurnitureOrder(String itemName, Date dateCreated, String shipToCity, int basePrice,
                          Customer customerOwned, String furnitureOrder) {
        super(itemName, dateCreated, shipToCity, basePrice, customerOwned);
        this.furnitureOrder = furnitureOrder;
    }

    @Override
    //Разбиваем валидациюЗаказа на логичесскую проверку  2-ух методов
    //проверка ЗаказаФурнитуры и проверка атрибутов Покупателя
    //если в результате проверки значение true то setDateConfirmed присваиваем сегодняшнюю дату
    public void validateOrder() {
        if (checkingFurnitureOrder() == true && checkingCustomer() == true)
            setDateConfirmed(new Date());
        System.out.println(getDateConfirmed());
    }

    //Проверка FurnitureOrder на город отправитель и цену
    //Каждое значение массива shipFromCity мы заносим в массив provCity
    //Потом сравниваем:  getShipToCity() на неравенство с  provCity
    // и (getBasePrice() с минимальной ценой заказа).
    //Если условие соблюдается то false иначе true
    private boolean checkingFurnitureOrder() {
        for (String provCity : shipFromCity){
            if((getShipToCity() != provCity) && (getBasePrice() < 500))
            return false;
        }
        return true;
    }

    //проверка атрибутов Кастомера(покупателя) по имени
    //если имя "Тест" то условие не выполняется (false) иначе выполняется (true)
    private boolean checkingCustomer() {
        if ( getCustomerOwned().getName() == "Тест") {
            return false;
        }
        return true;
    }

    @Override
    public void calculatePrice() {

        double totalsPrice;// сумма заказа
        if (getTotalPrice() <=0) {
            System.err.println("Base price can't be negative or  0");
            return;
        }
        if (getTotalPrice() < 5000) {
            //если сумма заказа < 5000 то сумма заказа == цена товара + цена товара *0,05
            //где 0,05 коммисия за доставку
            totalsPrice = getBasePrice() + getBasePrice() * 0.05;

        } else
            totalsPrice = getBasePrice() + getBasePrice() * 0.02;

        System.out.println(totalsPrice);
    }
}
