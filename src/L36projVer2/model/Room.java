package L36projVer2.model;

import java.util.Date;

public class Room {

    private long id;
    private int numbersOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvableFrom;
    private Hotel hotel;


    public Room(long id, int numbersOfGuests, double price,
                boolean breakfastIncluded, boolean petsAllowed, Date dateAvableFrom,
                Hotel hotel) {
        this.id = id;
        this.numbersOfGuests = numbersOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvableFrom = dateAvableFrom;
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", numbersOfGuests=" + numbersOfGuests +
                ", price=" + price +
                ", breakfastIncluded=" + breakfastIncluded +
                ", petsAllowed=" + petsAllowed +
                ", dateAvableFrom=" + dateAvableFrom +
                ", hotel=" + hotel +
                '}';
    }
}
