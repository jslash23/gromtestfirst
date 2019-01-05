package L35.controller;

import L35.model.Hotel;
import L35.service.HotelService;

import java.util.ArrayList;
import java.util.List;

public class HotelController   {
    private static HotelService hotelService = new HotelService();//зависимость
    public static ArrayList<Hotel> findHotelByName(String name, String path) throws Exception{

        return hotelService.findHotelByName(name,path);//

    }

    public static  ArrayList<Hotel> findHotelByCity(String city,String path) throws Exception{

        return hotelService.findHotelByCity(city,path);//

    }
}
