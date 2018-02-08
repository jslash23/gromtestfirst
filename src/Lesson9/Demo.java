package Lesson9;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        System.out.println(Arrays.deepToString (userRepository.getUsers()));

        User user = new User(1001,"Ann", "1f123215");
        userRepository.save(user);
        System.out.println(Arrays.deepToString (userRepository.getUsers()));

        userRepository.save(user);
        System.out.println(Arrays.deepToString (userRepository.getUsers()));

        // Тесты нужны для того чтоб минимизировать количество багов//
        //Проект хорошо покрытый тестами легок в дальнейшей разработке//

        //Выписываем кейсы как код можно использовать
        //1.Сохранение юзера +
        //2.Сохранение того же юзера, +  юзер сохраняется по ай ди ай ди уникален и новый юзер не должен добавится
        //3.Когда нет места в массиве +
        //4.Когда сохраняем null

        //Тестируем возвращаемое значение

        int n = 15;
        while (n > 0){
            User user1 = new User(n, "Ann","1f123215");
            System.out.println(userRepository.save(user1));
            n --;
        }

        System.out.println(Arrays.deepToString (userRepository.getUsers()));
        userRepository.save(null);

         //Тестируем метод update
        //1.Обновление юзера +
        //2.Когда нет юзера на обновление
        // если обновляем юзера с id которого нет в массиве ничего не должно происходить
        //3.Когда обновляем null

        user = new User(1001,"Ann","dhdhjhd");
        userRepository.update(user);
        System.out.println(Arrays.deepToString (userRepository.getUsers()));

        user = new User(9999,"Ann","dhdhjhd");
        System.out.println(userRepository.update(user));
        System.out.println(Arrays.deepToString (userRepository.getUsers()));

        System.out.println(userRepository.update(null));
        System.out.println(Arrays.deepToString (userRepository.getUsers()));
    }
}
