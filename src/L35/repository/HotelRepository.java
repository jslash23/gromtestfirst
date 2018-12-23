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

   public static ArrayList<Hotel> hotels = new ArrayList<>();
    public static Map<Long, Hotel> HotelMap = new HashMap<>();
    public String findHotelByName(String name) throws Exception {

        //String fileToPath = "";

        findStringByName(readFromFile("C:/Users/slash22/Desktop/HotelDb.txt"),name);

        return name;
    }

    public static Integer CreateId(Integer min, Integer max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }

    private static   Map<Long, Hotel> readFromFile(String path) throws Exception {//

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line= br.readLine()) != null) {

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

    public static Map<Long, Hotel>  convertDateFromFile(String[] lines ){
        Hotel newHotel = new Hotel(00, null, null, null, null);
        int i = 0;
        byte[] convBytes = lines[i].getBytes(); //
        newHotel.setId((long) convBytes[i]);
        i++;
        newHotel.setName(lines[i]);
        i++;
        newHotel.setCountry(lines[i]);
        i++;
        newHotel.setCity(lines[i]);
        i++;
        newHotel.setStreet(lines[i]);

        long id = (CreateId(0, 200));

        if (newHotel.getId() != id) {
            HotelMap.put(id, newHotel);
        }
        return null;
    }

    public static String findStringByName(Map<Long, Hotel> HotelMaps ,String name) {

            if (validateMapByName(HotelMaps, name)) {
                name = HotelMaps.toString();
                System.out.println(name);
                return name;
            }

            System.err.println("There is no file with current name!");
        return null;
    }

    public static boolean validateMapByName(Map<Long, Hotel> HotelMaps ,String name)  {

        ArrayList<Map> hotelsFiles = new ArrayList<>();

        hotelsFiles.add(HotelMaps);

      Iterator <Map>  hotelsIterator = hotelsFiles.iterator();

        while (hotelsIterator.hasNext()){//тут нужно сравнить name с  полем имя Отеля

            if (hotelsIterator.next().toString().contains(name)){
                return true;
            }
        }
        return false;
    }
}

