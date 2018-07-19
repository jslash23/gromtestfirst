package Lesson20.task.exception;

//Примитивное тестирование и отладка программы//

/*Необходимо реализовать небольшой кусочек проекта, отвечающий за сохранение объекта в условную базу данных
 (в нашем случае массив)
        Для этого создайте следующие сущности:

        User
        С полями
        long id
        String name
        String sessionId

        Объект должен создаваться по всем полям. Также возможность модификации полей должна быть закрыта,
         но возможность их считывания нет

        Класс UserRepository, который будет содержать поле User[] users, выполняющее роль условной базы
        данных (длина массива должна быть 10).
             Модифицировать содержимое этого массива можно только внутри класса UserRepository

            У класса должны быть публичные методы для работы с условной БД

        Метод  User save(User user) - который будет добавлять юзера в условную базу данных (массив)
            и возвращать его, если юзер уже есть в массиве, результат - null.
            Если размер массива не позволяет добавить больше элементов, результат метода тоже null



       Метод  User update(User user) - который будет обновлять текущего юзера
            и возвращать его, если юзера нет, результат - null

       Метод  void delete(long id) - удаляет юзера с массива
             Методы должны быть доступны всем

            Также реализуйте приватный метод, который будет использоваться только внутри класса
       Метод  User findById(long id). Используйте его в каждом из перечисленных выше методов
            Сравнение объектов User класса происходит через сравнение их полей id*/


public class UserRepository {

    private User[] users = new User[10];

    /*Метод  User save(User user) - который будет добавлять юзера в условную базу данных (массив)
    и возвращать его, если юзер уже есть в массиве, результат - null.
    Если размер массива не позволяет добавить больше элементов, результат метода тоже null*/

    public User save(User user) throws Exception {
        if (user == null)// если мы не передаем никакие параметры юзера то возвращаем налл
            throw new BadRequestException("Cant save null user");

        try{// Отлавливаем нашу ошибку  если ай ди такой уже есть в массиве то  возвращаем налл
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        }
        catch (UserNotFoundException e){//блок catch никогда не стоит оставлять пустым
            System.out.println("User with id " + user.getId() + " not found. Will be saved");
        }


        int index = 0;
        for (User us : users) {//заполняем ячейки массива новыми значениями
            if (us == null) {//если пустая ячейка то нулевой ячейке присвоиваем значение юзера
                users[index] = user;// и выходим к счетчику а++ и проверяем следующую ячейку
                return users[index];
            }
            index++;
        }//Если все юзеры перебраны то выдаем ошибку что места нет
        throw new InternalServelException("Not enought space to save user with id: " + user.getId());
    }

    public User update(User user) throws Exception {//если мы не передаем никакие параметры юзера то возвращаем налл
        if (user == null)
            throw new BadRequestException("Cant update null user");

         findById(user.getId());//если юзера с таким  ай ди нет то выбросится ошибка
        //если ай ди такой уже есть в массиве то выполняем цикл
            int index = 0;
            for (User us : users) {
                if (us != null && us.getId() == user.getId()) {
                    users[index] = user;
                    return users[index];
                }
                index++;
            }
            throw new InternalServelException("Unexpected error");
        }

    public void delete(long id) throws Exception {
        findById(id); //если пользователь есть в массиве то выполняем цикл
        //иначе выдаем ошибку о не существующем пользователе
            int index = 0;
            for (User us : users) {
                if (us.getId() == id) {
                    users[index] = null;
                    break;
                }
                index++;
            }
        }


    public User findById(long id) throws UserNotFoundException {
        for (User user : users) {
            if (user != null &&  id == user.getId())//если ячейка не пустая и id нового юзера
                // который мы передаем == id юзера который есть в масссиве
                return user;
        }
        throw new UserNotFoundException("User with id: " + id + " not found");
    }

    public User[] getUsers() {
        return users;
    }
}