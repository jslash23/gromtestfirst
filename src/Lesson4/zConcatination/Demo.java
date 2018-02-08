package Lesson4.zConcatination;

/**
 * Created by slash22 on 03.02.2018.
 */
//Выписываем кейсы как код можно использовать
//1.Сохранение со всеми стрингами +
//2.Сохранение с одним налом +
//3.Сохранение со всеми налами +

public class Demo {
    public static void main(String[] args) {
        System.out.println(ZadachaConcatination.concat("This string ", "was ", "concatination"));
        System.out.println(ZadachaConcatination.concat(null, "was ", "concatination"));
        System.out.println(ZadachaConcatination.concat(null, null, null));
    }
}
