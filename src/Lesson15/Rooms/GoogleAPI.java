package Lesson15.Rooms;

import java.util.Date;

public class GoogleAPI implements API {

    Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {//В массиве румз мы ищем по параметрам

        Room curRoom = new Room(price,persons,hotel,city);
        int count = 0;

            for (Room room : rooms) {
                if (room != null && room.equals(curRoom))//
                    count++;
            }

        Room[] APIRooms = new Room[count];

        int index = 0;// создаем индекс

            for (Room room : rooms) {//Пробегаем по массиву rooms
                if (curRoom!= null && room.equals(curRoom)){
                    APIRooms[index] = room;// записывем индекс в results
                    index++;
            }
        }
        return APIRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }

}

