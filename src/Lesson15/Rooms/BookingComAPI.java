package Lesson15.Rooms;

public class BookingComAPI implements API {

    Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (Room room : rooms) {

            if (room.getPersons() == persons && room.getPrice() >= price - 100 &&
                    room.getPrice() <= price + 100 && room.getCityName() == city &&
                    room.getHotelName() == hotel) {
                count++;
            }
        }
            Room[] bookingRooms = new Room[count];

            int index = 0;// создаем индекс

            for (Room room : rooms) {//Пробегаем по массиву rooms
                if (room.getPersons() == persons && room.getPrice() >= price - 100 &&
                        room.getPrice() <= price + 100 && room.getCityName() == city &&
                        room.getHotelName() == hotel) {
                    bookingRooms[index] = room;// записывем индекс в results
                    index++;
                }
            }
            return bookingRooms;
        }

        @Override
        public Room[] getAll () {
            return rooms;
        }
    }