package L35.repository;

import L35.model.User;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.StandardCopyOption;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UserRepository {
    //считывание данных - считывание файла
    //обработка данных - маппинг данных

    //Считать параметры юзера
    // Сгенерить новый ай ди
    //  замапить

    //после замапивания зписываем наш мап файл в файл на рабочем столе


    public User registerUser(User user) {
        //save user to db (file)
        //юзер на вход передаётся без поля id потому что айдишник генерем мы
        //юзер ай ди не вводит

        Map<Integer, User> usMap = new HashMap<>();

//айдишник должен генерится с уникальным номером, он не должен повторяться

        int id = (CreateId(0, 200));
        if (user.getId() != id) {
            usMap.put(id, user);

            String fileToPath = "C:/Users/slash22/Desktop/RepositoryDb.txt";
            writeToFile(fileToPath, readFromFile(usMap));

            System.out.println(usMap);


            return user;

        } else
            usMap.put(CreateId(0, 200), user);
            System.out.println(usMap);
        return user;
    }
    /*
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



     */

    private static StringBuffer readFromFile(Map <Integer,User> usMap) {
        StringBuffer res = new StringBuffer();

        try {
            res.append(usMap);
        }

        catch (Exception e) {
            System.out.println("Reading from file " + res + " failed");
        }

        finally {
            //IOUtils.closeQuietly(res);
        }
   return  res;
    }

    private static void   writeToFile(String path, StringBuffer contentToWrite){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.append(contentToWrite);

        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + path + " failed");
        }
    }



    public Integer CreateId(Integer min, Integer max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }
}
