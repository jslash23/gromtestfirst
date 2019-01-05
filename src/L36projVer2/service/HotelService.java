package L36projVer2.service;

import L36projVer2.model.Hotel;
import L36projVer2.repository.HotelRepository;

import java.util.ArrayList;


public class HotelService   {

    private HotelRepository hotelRepository = new HotelRepository();

    /*
       private long id;
       private String name;
       private String country;
       private String city;
       private  String street;
        */

    public ArrayList<Hotel> findHotelByName  (String name, String path) throws Exception {

            if (ValidateName(name)){
                return hotelRepository.findHotelByName(name, path);
            }

            System.err.println("you filds can't be null!");

        return null;
    }


    public  boolean ValidateName (String name){

        if (!name.isEmpty() && (name.matches("^[а-яА-ЯёЁa-zA-Z]+$")) ){
            return true;
        }
        return false;
    }

    public  ArrayList<Hotel> findHotelByCity (String city, String path) throws Exception {

        if (ValidateCity(city)){
            return hotelRepository.findHotelByCity(city,path);
        }

        System.err.println("you filds can't be null!");

        return null;
    }


    public  boolean ValidateCity(String city){

        if (!city.isEmpty() && (city.matches("^[а-яА-ЯёЁa-zA-Z]+$")) ){
            return true;
        }
        return false;
    }


}
