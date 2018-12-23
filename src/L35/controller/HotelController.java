package L35.controller;

import L35.service.HotelService;

public class HotelController   {
    private static HotelService hotelService = new HotelService();//зависимость
    public static  String findHotelByName(String name) throws Exception{

        return hotelService.findHotelByName(name);//

    }
}
