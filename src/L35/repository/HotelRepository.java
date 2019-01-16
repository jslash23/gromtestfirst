package L35.repository;

import L35.model.Hotel;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.*;

public class HotelRepository {

    //считываем данные,
    //преобразуем данные в объект
    // мапим в объект

    //находим гостиницу по имени
    //возвращаем объект

   public   ArrayList<Hotel> hotelsByCity = new ArrayList<>();

    //Hotel[] nHotels = new Hotel[2];
    ArrayList <Hotel>hotelsByName   = new ArrayList<>();
   public static String path = "C:/Users/slash22/Desktop/HotelDb.txt";

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {

        ArrayList <Hotel> wF = writeToFile(readFromFile(path,name));
        hotelsByName = findStringByName(wF, name);
        System.out.println(hotelsByName);
        return hotelsByName;
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {

        hotelsByCity = findStringByCity(writeToFile(readFromFile(path,city)), city);
        System.out.println(hotelsByCity);
        return hotelsByCity;
    }

    public Hotel addHotel(Hotel hotel){

        //save user to db (file)
        //юзер на вход передаётся без поля id потому что айдишник генерем мы
        //юзер ай ди не вводит

        ArrayList<Hotel> hotelList= new ArrayList<>();
        String fileToPathHotel = path;

        //айдишник должен генерится с уникальным номером, он не должен повторяться
        writeToFileHotelDb((fileToPathHotel),readFromHotel(hotel));

        System.out.println("Object hotel writen saccesfully to HotelDb.txt");
        return hotel;// правильно ли мы тут делаем возврат?
    }

    /*** deleteHotel(long hotelId)
    / *
    / * @param hotelId
     /* @return
    / * @throws Exception
     /*/
    public Long deleteHotel(long hotelId) throws Exception{ //тут возвращается Long или long

        /*
        0.Проверяем доступность записи данных в файл fileToPathHotel
        1. Читаем данные с файла "C:/Users/slash22/Desktop/HotelDb.txt"
        2.Преобразуем каждую строку прочитанного файла в объект
        3.Находим нужный id в объектах
        4.Удаляем строку с таким id
        5.Сохраняем наш файл
         */

        ArrayList<Hotel> hotelListDell = new ArrayList<>();
        String fileToPathHotel = path;

        validateHotelId(path);
        writeHotelIdToFile(path,(readHotelId(hotelId)));
        return hotelId;
    }

    public StringBuffer readHotelId (long id){
        StringBuffer res = new StringBuffer();//стринг буфер используется для записи стринга
        //он как передаточное звено между файл ридером и файл врайтером
        String needId = Long.toString(id);
        StringBuffer resNew = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line  ;
            int count = 0;

            while ((line = br.readLine()) != null) {
                String[] lines = line.trim().split(",");
                for (String linesnew : lines) {
                    if (!linesnew.contains(needId)){
                        res.append(linesnew);
                        res.append("");
                        res.append("\n");//добавляем новую строку
                    }
                }
            }
            //res.replace(res.length() - 1, res.length(), ""); //что мы тут делали?

        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + path + " failed");
        }
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(path))) {
            wr.append(resNew);

        } catch (IOException e) {
            System.out.println("Writing from file " + path + " failed");
        }
        return res;
    }

    private static void writeHotelIdToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            File file = new File(path);
            FileUtils.write(new File(path), "");
            bufferedWriter.append(contentToWrite);

        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + path + " failed");
        }
    }

    private static void validateHotelId(String path) throws Exception {

        File fileTo = new File(path);

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + path+ " does not exist");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File " + path + " does not has permission to be read");
        }
    }

        private static StringBuffer readFromHotel(Hotel hotel) {
        StringBuffer resHotel = new StringBuffer();
        long id = (CreateId(0, 200));
        hotel.setId(id);
        try {
            resHotel.append(hotel);
        }
        catch (Exception e) {
            System.out.println("Reading from file " + hotel + " failed");
        }
        return  resHotel;
    }

    /*** writeToFileHotelDb(String path, StringBuffer contentToWrite)
     *
     * @param path
     * @param contentToWrite
     */

    private static void   writeToFileHotelDb(String path, StringBuffer contentToWrite){
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        try { File file = new File(path);
            writer = new FileWriter(new File (path),true);

            bufferedWriter = new BufferedWriter(writer) ;
            bufferedWriter.append(contentToWrite);

        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + path + " failed");
        }
        finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }
    }

    private static Integer CreateId(Integer min, Integer max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }

    private static StringBuffer readFromFile(String path, String name) throws Exception {//

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

    /*** writeToFile(StringBuffer contentToWrite)
     *
     * @param contentToWrite
     * @return
     * @throws Exception
     */

    //Почему программа заменяет файлы в колекции АрейЛист HotelMap?
    private  ArrayList<Hotel> writeToFile(StringBuffer contentToWrite) throws Exception {

        ArrayList<Hotel> HotelMap = new ArrayList<>();
        Hotel nHotel1 = new Hotel(000,null,null,null,null);
        Hotel nHotel2 = new Hotel(000,null,null,null,null);

        String convString = contentToWrite.toString();
        String[] myList = convString.trim().split(",");

        int i = 1;

            {
                long id = (CreateId(0, 200));
                nHotel1.setId(id);
            }
            nHotel1.setName(myList[i]);
            i++;
            nHotel1.setCountry(myList[i]);
            i++;
            nHotel1.setCity(myList[i]);
            i++;
            nHotel1.setStreet(myList[i]);
            i++;
            HotelMap.add(nHotel1);

            {
                long id = (CreateId(0, 200));
                nHotel1.setId(id);
            }
            nHotel2.setName(myList[i]);
            i++;
            nHotel2.setCountry(myList[i]);
            i++;
            nHotel2.setCity(myList[i]);
            i++;
            nHotel2.setStreet(myList[i]);
            i++;
            HotelMap.add(nHotel2);
            //}
        return HotelMap;
    }

    /*** findStringByName(ArrayList<Hotel> HotelMap, String)
     *
     * @param HotelMap
     * @param name
     * @return
     * @throws Exception
     */

    public static ArrayList <Hotel> findStringByName(ArrayList<Hotel> HotelMap, String name) throws Exception {
        ArrayList <Hotel> hotelsNewByName   = new ArrayList<>();

            for (Hotel hotels : HotelMap) {
                if (hotels.getName().contains(name)) {
                    hotelsNewByName.add(hotels);
                    return hotelsNewByName;
                }
            }
             throw new Exception("There is no file with current name!");
    }

    public static ArrayList<Hotel> findStringByCity(ArrayList<Hotel> HotelMaps, String city) throws Exception {
          ArrayList<Hotel> hotelsNewByCity = new ArrayList<>();
        for (Hotel hotels : HotelMaps) {
            if (hotels.getCity().contains(city)) {
                hotelsNewByCity.add(hotels);
                return hotelsNewByCity;
            }
        }
        throw new Exception("There is no file with current city!");
    }
}



