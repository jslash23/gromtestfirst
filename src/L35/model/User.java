package L35.model;

import java.util.List;

public class User {
    private long id;
    private String userName;
    private String country;
    private List <Room> roomsReserved;

    public User(long id, String userName, String country, List<Room> roomsReserved) {
        this.id = id;
        this.userName = userName;
        this.country = country;
        this.roomsReserved = roomsReserved;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getCountry() {
        return country;
    }

    public List<Room> getRoomsReserved() {
        return roomsReserved;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRoomsReserved(List<Room> roomsReserved) {
        this.roomsReserved = roomsReserved;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", country='" + country + '\'' +
                ", roomsReserved=" + roomsReserved +
                '}';
    }
}
