package Lesson22.arrays.el_koshelek_stat;

//класс контроллер принимает запросы пользователя распределяет их и вызывает  часть нужного бекенда
//которая отвечает за обработку того или иниго запроса
//дао отвечает за работу с данными контроллер отвечает за роутинг запросов на сервер

public class Controller {
    //тут контролер выполняет роль поиска нужного метода
    //в других случаях может быть в методе контролера дополнительная логика
    //например добавляем в контроллер статус ошибки
    //create response
    //return response

    private static   TransactionDAO transactionDAO;// = new TransactionDAO();

    public static Transaction save(Transaction transaction ) throws Exception{//Возвращаем тот объект
        // который сохранили

        return transactionDAO.save(transaction);
    }

    public static Transaction[] transactionList(){
        return  transactionDAO.transactionList();
    }

    public static Transaction[] transactionList(String city) {
        return  transactionDAO.transactionList(city);
    }

   public static Transaction[] transactionList(int amount){
        return  transactionDAO.transactionList(amount);
    }
}
