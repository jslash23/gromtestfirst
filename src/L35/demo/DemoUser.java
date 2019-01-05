package L35.demo;

import L35.controller.HotelController;
import L35.model.Room;
import L35.model.User;
import L35.model.Hotel;
import L35.controller.UserController;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DemoUser {

    public static void main(String[] args)throws Exception{

        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Hotel> hotels = new ArrayList<>();

        Hotel hotel1 = new Hotel(235,"PrimerPalace","Ukraine","Kiev","Hreshatik25" );
        Hotel hotel2 = new Hotel(270,"Lybyd" ,"Ukraine","Kiev","Baseynaya23" );

        Room room1 = new Room(001,2,352.50,true,true,new Date(),hotel1);
        Room room2 = new Room(002,3,355.50,true,false,new Date(),hotel2);
        rooms.add(room1);

        User user1 = new User(111,"Dimon","Ukraine",rooms);

       //Calendar d1 =  Calendar.set(year + 1900, 05, 18);
        //GregorianCalendar calendar1 = new GregorianCalendar(2018,Calendar.DECEMBER,29);

        System.out.println("registerUser:  ");
        UserController.registerUser(user1);
        System.out.println();
        System.out.println("findHotelByName:   ");
        HotelController.findHotelByName("HersonPalace","C:/Users/slash22/Desktop/HotelDb.txt");
        System.out.println("findHotelByCity:   ");
        HotelController.findHotelByCity("Herson","C:/Users/slash22/Desktop/HotelDb.txt");
    }
}
