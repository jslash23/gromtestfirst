package L35.controller;


import L35.model.User;
import L35.service.UserService;

public class UserController {
    private static UserService userService = new UserService();//зависимость

   public static User registerUser(User user){

        return userService.registerUser(user);//тут должна быть логика
    }


}
