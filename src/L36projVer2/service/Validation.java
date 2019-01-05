package L36projVer2.service;

import L36projVer2.model.Room;

import java.util.List;


public interface Validation  {

    /*
     private long id;
    private String userName;
    private String country;
    private List <Room> roomsReserved;
     */

    boolean Validate(String userName, String country, List<Room> roomsReserved);

    /*
    private long id;
    private String name;
    private String country;
    private String city;
    private  String street;
     */

    //boolean ValidateName (String name);
}
