package L36projVer2.service;

import L36projVer2.model.Room;
import L36projVer2.model.User;
import L36projVer2.repository.UserRepository;

import java.util.List;

public class UserService implements Validation {

    private UserRepository userRepository = new UserRepository();

    public User registerUser  (User user) {

       //check business logic
       //объекты не должны содержать пустых полей
       //if busines logic ok return user
       // else return exeption, потому что логика не прошла

       //возвращаем то что вернул метод registerUser нашего userRepository

       if (Validate(user.getUserName(), user.getCountry(), user.getRoomsReserved())){
           return userRepository.registerUser(user);
           }
       System.err.println("you filds can't be null!");
       return null;
   }

    @Override
    public boolean Validate (String userName, String country, List<Room> roomsReserved){

       if (userName != null && country != null && roomsReserved != null ){
           return true;
       }
        return false;
    }
}
