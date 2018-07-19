package Lesson15.UserRepositary;

import Lesson9.*;
import Lesson9.User;

import java.util.Arrays;

/**
 * Created by slash22 on 17.03.2018.
 */
public class Demo {
    public static void main(String[] args) {
        Lesson9.UserRepository userRepository = new Lesson9.UserRepository();
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        Lesson9.User user = new Lesson9.User(1, "dre", "22");


        userRepository.save(null);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //userRepository.save(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        // Тесты нужны для того чтоб минимизировать количество багов//
        //Проект хорошо покрытый тестами легок в дальнейшей разработке//

        //Выписываем кейсы как код можно использовать
        //1.Сохранение юзера +
        //2.Сохранение того же юзера, +  юзер сохраняется по ай ди ай ди уникален и новый юзер не должен добавится
        //3.Когда нет места в массиве +
        //4.Когда сохраняем null

        //Тестируем возвращаемое значение

        int n = 15;
        while (n > 0) {
            Lesson9.User user1 = new Lesson9.User(n, "Ann", "1f123215");
            System.out.println(userRepository.save(user1));
            n--;
        }

        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        userRepository.save(null);

        //Тестируем метод update
        //1.Обновление юзера +
        //2.Когда нет юзера на обновление
        // если обновляем юзера с id которого нет в массиве ничего не должно происходить
        //3.Когда обновляем null

        user = new Lesson9.User(1001, "Anet", "dhdhjhd");
        userRepository.update(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        user = new User(9999, "Ann", "dhdhjhd");
        System.out.println(userRepository.update(user));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        System.out.println(userRepository.update(null));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //Тестируем на удаляемое значение

        System.out.println("Обнуляем массив");
        int k = 15;
        while (k > 0) {
            //Lesson9.User user1 = new Lesson9.User(k, "", "");
            userRepository.delete(k);
            System.out.println(Arrays.deepToString(userRepository.getUsers()));
            k--;
        }
    }
}
