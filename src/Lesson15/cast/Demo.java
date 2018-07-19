package Lesson15.cast;

//Операция Cast это приведение более широкого типа объектов к более узкому типу объектов
// каст делает от общего родителя к более низкому уровню

public class Demo {
    public static void main(String[] args) {
        InternetProvider provider = (InternetProvider) test();//сделали кастомную операцию
        //  указали что возвращаемый тип InternetProvider не является ошибкой

        FoodProvider foodProvider = (FoodProvider) testFood();//testFood возвращает InternetProvider
        // а мы его пытаемся привести к типу FoodProvider потому что два разных класса с одинаковым родителем
        //класс CastException крайне не рекомендуют использовать в виду того что можно в нем запутаться и наделать
        //много ошибок в коде

        System.out.println(provider);
    }


    private static Provider test(){
        //logic
        return new InternetProvider();
    }

    private static Provider testFood(){
        //logic
        return new InternetProvider();//testFood возвращает InternetProvider
    }
}
