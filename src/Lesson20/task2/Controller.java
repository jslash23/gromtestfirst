package Lesson20.task2;

//класс контроллер принимает запросы пользователя распределяет их и вызывает  часть нужного бекенда
//которая отвечает за обработку того или иниго запроса
//дао отвечает за работу с данными контроллер отвечает за роутинг запросов на сервер
public class Controller {//тут контролер выполняет роль поиска нужного метода
    //в других случаях может быть в методе контролера дополнительная логика
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction ) throws Exception{//Возвращаем тот объект
        // который сохранили
        return transactionDAO.save(transaction);
        //например добавляем в контроллер статус ошибки
        //create response
        //return response
    }

    Transaction[] transactionList(){
        return  transactionDAO.transactionList();
    }

    Transaction[] transactionList(String city){
        return  transactionDAO.transactionList();
    }

    Transaction[] transactionList(int amount){
        return  transactionDAO.transactionList();
    }

}
