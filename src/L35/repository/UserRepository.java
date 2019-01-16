package L35.repository;

import L35.model.User;
import org.apache.commons.io.IOUtils;
import java.io.*;
import java.util.ArrayList;
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

        ArrayList<User> usMap = new ArrayList<>();
        String fileToPath = "C:/Users/slash22/Desktop/RepositoryDb.txt";

//айдишник должен генерится с уникальным номером, он не должен повторяться
        writeToFile((fileToPath),readFromUser(user));

            System.out.println("File user writen saccesfully");
            return user;
        }

    private static StringBuffer readFromUser(User user) {
        StringBuffer res = new StringBuffer();
        long id = (CreateId(0, 200));
        user.setId(id);
        try {
            res.append(user);
        }
        catch (Exception e) {
            System.out.println("Reading from file " + res + " failed");
        }
   return  res;
    }

    private static void   writeToFile(String path, StringBuffer contentToWrite){
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        try { File file = new File(path);
            writer = new FileWriter(new File (path),true);
            //bufferedWriter = new BufferedWriter(writer);

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

    public static Integer CreateId(Integer min, Integer max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }
}
