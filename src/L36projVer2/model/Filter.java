package L36projVer2.model;

import java.util.Date;

public class Filter {


    private int numbersOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvableFrom;

    //вместо поля   private Hotel hotel пишем
    private String country;
    private String city;

    public Filter(int numbersOfGuests, double price, boolean breakfastIncluded,
                  boolean petsAllowed, Date dateAvableFrom, String country, String city) {
        this.numbersOfGuests = numbersOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvableFrom = dateAvableFrom;
        this.country = country;
        this.city = city;
    }
}
