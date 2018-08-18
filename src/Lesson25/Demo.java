package Lesson25;


import Dopolnitelno.Test;

public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO generalDAO = new GeneralDAO();

        Order order = new Order(1);
        generalDAO.validate(order);//тут может быть ошибка потому что метод
        // validate ждет все классы которые наследуются от IdEntity а Order
        // не наследуется

        TestClass<String,Order,Long> testClass = new TestClass<>();// дженерики
        //могут быть одинаковых типов
        System.out.println(testClass.doSomething1("rrr"));

        //long - Long
        //int - Integer
        //short - Short

       int test = 100;
       long variable = 111;//это не объект, это переменная типа лонг

       Long variable2 = new Long(222);//это переменная типа лонг и одновременно
        //объект типа лонг
        //Классы обертки (Long,Integer,Short,Char) созданы для того чтоб мы могли
        //с такими переменными работать как с объектом

        generalDAO.validate(variable2);

        generalDAO.validate(variable);//компилятор сделал каст:
        //Long variable3 = (Long) variable
        //generalDAO.validate(variable3)
       // Long variable3 = (Long) test;//не работает потому что разные типы
        //кастомизация работает когда типы одинаковые, например long - Long

        generalDAO.validate(test);


    }


}
