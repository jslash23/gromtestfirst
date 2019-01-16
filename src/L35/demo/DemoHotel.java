package L35.demo;

import L35.controller.HotelController;
import L35.model.Hotel;
import L35.model.Room;
import L35.model.User;


import java.util.ArrayList;
import java.util.Date;

public class DemoHotel {
    public static void main(String[] args) throws Exception {

        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Hotel> hotels = new ArrayList<>();

        Hotel hotel1 = new Hotel(235,"PrimerPalace","Ukraine","Kiev","Hreshatik25" );
        Hotel hotel2 = new Hotel(270,"Lybyd" ,"Ukraine","Kiev","Baseynaya23" );

        Room room1 = new Room(001,2,352.50,true,true,new Date(),hotel1);
        Room room2 = new Room(002,3,355.50,true,false,new Date(),hotel2);
        rooms.add(room1);

        User user1 = new User(111,"Dimon","Ukraine",rooms);

        System.out.println("findHotelByName:   ");
        HotelController.findHotelByName("KievPalace");
        System.out.println("findHotelByCity:   ");
        HotelController.findHotelByCity("Herson");
        HotelController.addHotel(hotel2);
        HotelController.deleteHotel(150);
    }
}
