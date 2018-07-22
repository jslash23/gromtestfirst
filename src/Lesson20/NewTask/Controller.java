package Lesson20.NewTask;

import Lesson20.task.exception.BadRequestException;

//класс контроллер принимает запросы пользователя распределяет их и вызывает  часть нужного бекенда

public class Controller {//тут контролер выполняет роль поиска нужного метода

    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction ) throws Exception{//Возвращаем тот объект

        return transactionDAO.save(transaction);

    }

    Transaction[] transactionList()throws  Exception{
        return  transactionDAO.transactionList();
    }

    Transaction[] transactionList(String city)throws  BadRequestException {
        return  transactionDAO.transactionList(city);//кидаем сити
    }

    Transaction[] transactionList(int amount)throws  BadRequestException{
        return  transactionDAO.transactionList(amount);//кидаем амаунт
    }
}
