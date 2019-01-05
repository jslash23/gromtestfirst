package L36projVer2.controller;


import L36projVer2.model.User;
import L36projVer2.service.UserService;

public class UserController {
    private static UserService userService = new UserService();//зависимость

   public static User registerUser(User user){

        return userService.registerUser(user);//тут должна быть логика
    }


}
