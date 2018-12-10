package L35.repository;

import L35.model.User;

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

        Map<Integer, User> usMap1 = new HashMap<>();

//айдишник должен генерится с уникальным номером, он не должен повторяться

        int id = (CreateId(0, 200));
        if (user.getId() != id) {
            usMap1.put(id, user);

            System.out.println(usMap1);
            return user;

        } else
            usMap1.put(CreateId(0, 200), user);
            System.out.println(usMap1);
        return user;
    }

    /*public  void writeFileContent(User user, String fileToPAth) throws Exception{
        //Проверить что файлы есть +
        //проверить права +
        //Считать контент файла from +
        //считать контент файла to +

        registerUser(User user, String fileToPAth );

        validate(fileFromPath,fileToPAth);
        writeToFile(fileToPAth,readFromFile(fileFromPath));

    }*/

    public Integer CreateId(Integer min, Integer max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }
}
