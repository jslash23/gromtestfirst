package L35.controller;

import L35.model.Hotel;
import L35.service.HotelService;
import java.util.ArrayList;

public class HotelController   {
    private static HotelService hotelService = new HotelService();//зависимость
    public static ArrayList<Hotel> findHotelByName(String name) throws Exception{

        return hotelService.findHotelByName(name);//

    }

    public static  ArrayList<Hotel> findHotelByCity(String city) throws Exception{

        return hotelService.findHotelByCity(city);//
    }

    public static Hotel addHotel(Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    public static Long deleteHotel(long id) throws  Exception {
        return hotelService.deleteHotel(id);
    }
}
