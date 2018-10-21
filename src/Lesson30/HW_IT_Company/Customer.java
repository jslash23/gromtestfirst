package Lesson30.HW_IT_Company;


public class Customer {

    private String name;
    private  String country;
   private int mothlyPay;

    public Customer() {
    }

    public Customer(String name, String country, int mothlyPay) {
        this.name = name;
        this.country = country;
        this.mothlyPay = mothlyPay;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getMothlyPay() {
        return mothlyPay;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", mothlyPay=" + mothlyPay +
                '}';
    }
}
