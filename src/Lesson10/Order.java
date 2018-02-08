package Lesson10;

import java.util.Date;

public abstract class Order {

    private String itemName;
    private Date dateCreated;
    public Date dateConfirmed;
    public Date dateShipped ;
    private String shipFromCity;
    private String shipToCity;
    private int basePrice;
    public double totalPrice;
    private Customer customerOwned;


    public Order(String itemName, Date dateCreated,
                 String shipToCity, int basePrice, Customer customerOwned) {
        this.itemName = itemName;
        this.dateCreated = dateCreated;
        this.shipToCity = shipToCity;
        this.basePrice = basePrice;
        this.customerOwned = customerOwned;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateConfirmed() {
        return dateConfirmed;
    }

    public Date getDateShipped() {
        return dateShipped;
    }

    public void setDateConfirmed(Date dateConfirmed) {
        this.dateConfirmed = dateConfirmed;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomerOwned() {
        return customerOwned;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public String getShipFromCity() {
        return shipFromCity;
    }

    public String getShipToCity() {
        return shipToCity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getItemName() {
        return itemName;
    }

   public abstract void validateOrder();

   public abstract void calculatePrice();

    public void confirmShipping() {
        if (dateShipped == null)
            setDateShipped(new Date());
        System.out.println(getDateShipped());
    }

    @Override
    public String toString() {
        return "Order{" +
                "itemName='" + itemName + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateConfirmed=" + dateConfirmed +
                ", dateShipped=" + dateShipped +
                ", shipFromCity='" + shipFromCity + '\'' +
                ", shipToCity='" + shipToCity + '\'' +
                ", basePrice=" + basePrice +
                ", totalPrice=" + totalPrice +
                ", customerOwned=" + customerOwned +
                '}';
    }
}

