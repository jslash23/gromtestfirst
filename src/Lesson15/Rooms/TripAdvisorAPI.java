package Lesson15.Rooms;

public class TripAdvisorAPI implements API {

    Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int count = 0;
        for (Room room : rooms) {
            if (room.getPrice() == price && room.getPersons() >= persons -1 &&
                    room.getPersons() <= persons + 1 && room.getCityName() == city &&
                    room.getHotelName() == hotel)
                count++;
        }
        Room[] personsRooms = new Room[count];

        int index = 0;// создаем индекс
        for (Room room : rooms) {//Пробегаем по массиву rooms
            if (room.getPrice() == price && room.getPersons() >= persons -1 &&
                    room.getPersons() <= persons + 1 && room.getCityName() == city &&
                    room.getHotelName() == hotel) {
                personsRooms[index] = room;// записывем индекс в results
                index++;
            }
        }
        return personsRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
