package Lesson10;

import java.util.Date;

public class ElectronicsOrder extends Order {
    //Одинаковые параметры города отправителя и города покупателя
    private String[] shipFromAndToCity = {"Киев", "Одесса", "Днепр", "Харьков"};
    private String[] shipToTheCity = {"Киев", "Одесса", "Днепр", "Харьков"};

    int guaranteeMonth;


    public ElectronicsOrder(String itemName, Date dateCreated, String shipToCity, int basePrice,
                            Customer customerOwned, int guaranteeMonth) {
        super(itemName, dateCreated, shipToCity, basePrice, customerOwned);
        this.guaranteeMonth = guaranteeMonth;
    }

    @Override
    public void validateOrder() {
        //разделили валидацию заказа на проверку двух методов
        //Проверяем Электронный Заказ и Атрибуты покупателя,
        //если true и true то выставляем сегодняшнюю дату подтвержения заказа

        if (checkingElectronicsOrder() == true && checkingCustomer() == true)
            setDateConfirmed(new Date());
        System.out.println(getDateCreated());
    }

    //Метод проверяет ElectronicsOrder (Электронный Заказ) на город отправитель и цену
    private boolean checkingElectronicsOrder() {//
        for (String provCity : shipFromAndToCity) {
            if ((getBasePrice() < 0) | (getBasePrice() == 0)) {System.err.println("Base price can't be negative or  0");
            break;}
                if ((getShipFromCity() != provCity) && (getBasePrice() < 100))
                    return false;
        }
        return true;
    }

    //Метод проверяет атрибуты Customer на город доставки и пол
    //город доставки мы как бы пишем в поле город клиента (city)
    //
    private boolean checkingCustomer() {
        //Проходимся по всем shipToTheCity и заносим каждый в provCity1
        for (String provCity1 : shipToTheCity) {
            //Если город клиента и пол клиента не совпадают с условием валидации то false иначе true
            //мы берем наше значение доставки и сравниваем с городом клиента
            if ((getCustomerOwned().getCity() != provCity1) && (getCustomerOwned().getGender() != "Женский"))
                return false;
        }
        return true;
    }

    @Override
    //Метод расчета цены
    public void calculatePrice() {

        double totalsPrice;
        if ((getBasePrice() < 0) | (getBasePrice() == 0)) {System.err.println("Base price can't be < 0");
        return;}
        //!!!
        if (!(getShipToCity().equals("Киев") || getShipToCity().equals("Одесса"))) {
            //Общая цена (totalPrice) равна цена за товар + цена за доставку
            totalsPrice = getBasePrice() + getBasePrice() * 0.15;
        } else {
            totalsPrice = getBasePrice() + getBasePrice() * 0.10;

        }
        if (totalsPrice > 1000) {
            //Если общая цена > 1000 то скидка на заказ  5% после проплаты комисии за доставку
            //проплатили комисию за доставку мы выше
            totalsPrice = totalsPrice - totalsPrice * 0.05;
        }

        System.out.println(totalsPrice);
    }
}

