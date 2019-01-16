package L35.service;

import L35.model.Hotel;
import L35.model.Room;
import L35.model.User;
import L35.repository.HotelRepository;

import java.util.ArrayList;
import java.util.List;

public class HotelService {/*implements ValidateHotel   */

    private HotelRepository hotelRepository = new HotelRepository();

    //check business logic
    //объекты не должны содержать пустых полей
    //if busines logic ok return user
    // else return exeption, потому что логика не прошла


    public ArrayList<Hotel> findHotelByName  (String name) throws Exception {

            if (ValidateName(name)){
                return hotelRepository.findHotelByName(name);
            }
            System.err.println("you filds can't be null!");
        return null;
    }

    public Hotel addHotel(Hotel hotel){

        //Тут мы напишем проверку привилегии пользователя (Юзер Админ или просто Юзер?)

        if (ValidateHotel(hotel.getName(), hotel.getCountry(),hotel.getStreet())){
            return hotelRepository.addHotel(hotel);
        }
        System.err.println("you filds can't be null!");
        return null;
    }

    public Long deleteHotel(long hotelId) throws Exception{
        //проверяем в бизнес

        return hotelRepository.deleteHotel(hotelId) ;
    }


   /* public void findHotel (Hotel hotel){
        //Test level of privilegue of USER
        if (!ValidateUserType()){

        }

    }*/

    /*public boolean ValidateUserType (){
        if (!User.UserType.ADMIN){

        }
    }*/


    //boolean ValidHotel (Enum UserType, String hotelName, String hotelCountry, String hotelStreet);


    public boolean ValidateHotel (/*Enum UserType,*/ String hotelName, String hotelCountry, String hotelStreet){

        //if (User.UserType.ADMIN)

        if ( hotelName != null && hotelCountry != null && hotelStreet != null ){
            return true;
        }
        return false;
    }


    public  boolean ValidateName (String name){

        if (!name.isEmpty() && (name.matches("^[а-яА-ЯёЁa-zA-Z]+$")) ){
            return true;
        }
        return false;
    }

    public  ArrayList<Hotel> findHotelByCity (String city) throws Exception {

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
