package L36projVer2.controller;

import L36projVer2.model.Hotel;
import L36projVer2.service.HotelService;

import java.util.ArrayList;

public class HotelController   {
    private static HotelService hotelService = new HotelService();//зависимость
    public static ArrayList<Hotel> findHotelByName(String name, String path) throws Exception{

        return hotelService.findHotelByName(name,path);//

    }

    public static  ArrayList<Hotel> findHotelByCity(String city, String path) throws Exception{

        return hotelService.findHotelByCity(city,path);//

    }
}
