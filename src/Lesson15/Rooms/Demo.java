package Lesson15.Rooms;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Room room1 = new Room(1,100,2,new Date(),"Rivera","Kiev");
        Room room2 = new Room(2,150,3,new Date(),"Palace","Kiev");
        Room room3 = new Room(3,200,2,new Date(),"Dnipro","Harkov");
        Room room4 = new Room(4,250,3,new Date(),"Plaza","Lviv");
        Room room5 = new Room(5,300,3,new Date(),"Prima","Krim");

        Room[] rooms = new Room[]{room1, room2, room3, room4, room5};

        //Room[] rooms1 = new Room[]{room1,room3};

        BookingComAPI bookingComAPI = new BookingComAPI(rooms);// В реализацию всовываем массив комнат
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
        GoogleAPI googleAPI = new GoogleAPI(rooms);
       // System.out.println((rooms1));

        System.out.println("Test find");

        //System.out.println(Arrays.toString(rooms));
        System.out.println(Arrays.deepToString(find(rooms, tripAdvisorAPI)));
        System.out.println("вывод гугл апи");
        System.out.println(Arrays.deepToString(find(rooms, googleAPI)));


        System.out.println("Test find circle");
        for (Room room: find(rooms, bookingComAPI)){
            System.out.println(room.getPrice() + " " +room.getPersons() + " " + room.getCityName()
                    + " " + room.getHotelName());
        }

      // System.out.println(Arrays.toString(findRooms, bookingComAPI
        // (100,2,"Kiev","Rivera")));// Обращаемся к каждой реализации

        //System.out.println(find(rooms, tripAdvisorAPI));
        //System.out.println(find(rooms, googleAPI));
    }

    private static  Room[] find(Room[] rooms, API api){//Указываем что мы ищем
             api.findRooms(150,3, "Kiev","Palace");
        return rooms;
    }

/*
  Room [] newRooms = {room1,room2,room3,room4,room5,room6};
        BookingComAPI bookingComAPI = new BookingComAPI(newRooms);

        System.out.println(Arrays.toString(bookingComAPI.findRooms(300,2,"Киев", "Общага")));
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(newRooms);
        GoogleAPI googleAPI = new GoogleAPI(newRooms);
        API[] newApies = {bookingComAPI,tripAdvisorAPI,googleAPI};
       Controller controller = new Controller(newApies);*/

       //


}
