package L35.service;

import L35.model.Room;

import java.util.List;


public interface Validation  {
    /*
     private long id;
    private String userName;
    private String country;
    private List <Room> roomsReserved;
     */

    boolean Validate (String userName, String country, List<Room> roomsReserved);

}
