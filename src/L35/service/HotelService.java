package L35.service;

import L35.model.Hotel;
import L35.repository.HotelRepository;


public class HotelService   {

    private HotelRepository hotelRepository = new HotelRepository();

    /*
       private long id;
       private String name;
       private String country;
       private String city;
       private  String street;
        */

    public  String findHotelByName  (String name) throws Exception {

            if (ValidateName(name)){
                return hotelRepository.findHotelByName(name);
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

    public  String findHotelByCity (String city) throws Exception {

        if (ValidateCity(city)){
            return hotelRepository.findHotelByCity(city);
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
