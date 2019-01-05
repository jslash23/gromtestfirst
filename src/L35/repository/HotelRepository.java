package L35.repository;

import L35.model.Hotel;

import java.io.*;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.*;
import java.util.Iterator;

public class HotelRepository {

    //считываем данные,
    //преобразуем данные в объект
    // мапим в объект

    //находим гостиницу по имени
    //возвращаем объект

   public static ArrayList<Hotel> hotelsByName = new ArrayList<>();
   public static ArrayList<Hotel> hotelsByCity = new ArrayList<>();

    public ArrayList<Hotel> findHotelByName(String name, String path) throws Exception {

        ArrayList <Hotel> wF = writeToFile(readFromFile(path));
        hotelsByName = findStringByName(wF, name);
       //String hotelsByName1 = hotelsByName.toString();
        System.out.println(hotelsByName);
        return hotelsByName;
    }

    public ArrayList<Hotel> findHotelByCity(String city, String path) throws Exception {

        hotelsByCity = findStringByCity(writeToFile(readFromFile(path)), city);
        //String hotelsByCity = Hotels.toString();
        System.out.println(hotelsByCity);
        return hotelsByCity;
    }


    private static Integer CreateId(Integer min, Integer max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }


    //тут нужно использовать мап иначе затирается предыдущий объект хостел
    private static StringBuffer readFromFile(String path) throws Exception {//

        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
        } catch (IOException e) {
            System.out.println("Reading from file " + path + " failed");
        }
        return res;
    }

    //Почему программа заменяет файлы в колекции АрейЛист HotelMap?
    private static ArrayList<Hotel> writeToFile(StringBuffer contentToWrite) throws Exception {
        Hotel nHotel = new Hotel(00, null, null, null, null);
        ArrayList<Hotel> HotelMap = new ArrayList<>();

        String convString = contentToWrite.toString();
        String[] myList = convString.trim().split(",");

        int i = 1;
        for (int j = 0; j < 2; j++) {
            {
                long id = (CreateId(0, 200));
                nHotel.setId(id);
            }

            //String s = myList[i];
            //String s = myList[i];
            // long n = Long.valueOf(long);
            //long number = Long.valueOf(s).longValue();
            //Long  sNew = new Long(s);

            /*try {
                long number  = Long.parseLong(s);

            } catch (NumberFormatException e) {
                System.out.println(s + " is not a valid number.");
            }*/

            //long number = new Long(s).longValue();
            //long n = Long.parseLong(s);

            nHotel.setName(myList[i]);
            i++;
            nHotel.setCountry(myList[i]);
            i++;
            nHotel.setCity(myList[i]);
            i++;
            nHotel.setStreet(myList[i]);
            i++;
            HotelMap.add(nHotel);

            }

        return HotelMap;
    }

    //делаем из стринга массив стрингов
    //каждый стринг преобразуем в нужное значение

/*public  static ArrayList<Hotel> stringByName(ArrayList<Hotel> HotelMap, String name){
    for (Hotel hotels : HotelMap) {
        HotelMap = hotels.getName().contains(name);

        }
}*/


    public static ArrayList<Hotel> findStringByName(ArrayList<Hotel> HotelMap, String name) throws Exception {


            for (Hotel hotels : HotelMap) {
                if (hotels.getName().contains(name)) {
                    return HotelMap;
                }
            }

             throw new Exception("There is no file with current name!");
    }

    public static ArrayList<Hotel> findStringByCity(ArrayList<Hotel> HotelMaps, String city) throws Exception {
        //как  мне сделать такую конструкцию

        for (Hotel hotels : HotelMaps) {
            if (hotels.getCity().contains(city)) {
                return HotelMaps;
            }
        }
        throw new Exception("There is no file with current city!");
    }
}



