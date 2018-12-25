package L35.repository;

import L35.model.Hotel;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Iterator;

public class HotelRepository {

    //считываем данные,
    //преобразуем данные в объект
    // мапим в объект

    //находим гостиницу по имени
    //возвращаем объект


    public static ArrayList<Hotel> HotelMap = new ArrayList<>();


    public String findHotelByName(String name) throws Exception {
        List<Hotel>  Hotels = new ArrayList<>();

        Hotels = findStringByName(readFromFile("C:/Users/slash22/Desktop/HotelDb.txt"), name);
        String hotelsByName = Hotels.toString();
        System.out.println("Our hotels by name : " + hotelsByName);
        return  hotelsByName ;
    }

    public String findHotelByCity(String city) throws Exception {
        List<Hotel>  Hotels = new ArrayList<>();
        Hotels = findStringByCity(readFromFile("C:/Users/slash22/Desktop/HotelDb.txt"), city);
        String hotelsByCity = Hotels.toString();

        System.out.println("Our hotels by City : " + hotelsByCity);
        return  hotelsByCity ;
    }


    public static Integer CreateId(Integer min, Integer max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }

    private static ArrayList<Hotel> readFromFile(String path) throws Exception {//

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {

                //делаем из стринга массив стрингов
                //каждый стринг преобразуем в нужное значение

                String[] lines = line.split("[ ]");
                convertDateFromFile(lines);

                //System.out.println(line + "  read");
            }

        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + path + " failed");
        }

        return HotelMap;
    }

    public static ArrayList<Hotel> convertDateFromFile(String[] lines) {
        Hotel newHotel = new Hotel(00, null, null, null, null);

        int i = 0;

        byte[] convBytes = lines[i].getBytes(); //

        if (convBytes.equals(null)){
            long id = (CreateId(0, 200));
            newHotel.setId(id);
        }

        else {

            newHotel.setId(convBytes[i]);
            i++;
        }
        newHotel.setName(lines[i]);
        i++;
        newHotel.setCountry(lines[i]);
        i++;
        newHotel.setCity(lines[i]);
        i++;
        newHotel.setStreet(lines[i]);

            HotelMap.add(newHotel);

        return HotelMap;
    }

    public static ArrayList<Hotel> findStringByName(ArrayList<Hotel> HotelMaps, String name) throws Exception {

        ArrayList<Hotel> hotelsFiles = new ArrayList<>();

            for (Hotel hotels : HotelMaps) {
                if (hotels.getName().equals(name)) {
                    hotelsFiles.add(hotels);
                    return hotelsFiles;
                }
            }

         throw new Exception  ( "There is no file with current name!");
    }
    
    public static ArrayList<Hotel> findStringByCity(ArrayList<Hotel> HotelMaps, String city) throws Exception {

        ArrayList<Hotel> hotelsFiles = new ArrayList<>();

        for (Hotel hotels : HotelMaps) {
            if (hotels.getCity().equals(city)) {
                hotelsFiles.add(hotels);
                return hotelsFiles;
            }
        }

        throw new Exception  ( "There is no file with current city!");
    }
}

