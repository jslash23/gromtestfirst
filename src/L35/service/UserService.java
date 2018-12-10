package L35.service;

import L35.model.Room;
import L35.repository.UserRepository;
import L35.model.User;
import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.*;

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
