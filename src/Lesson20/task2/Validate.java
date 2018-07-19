package Lesson20.task2;

/**
 * Created by slash22 on 18.07.2018.
 */
import Lesson20.task2.exceptions.InternalServerException;
import Lesson20.task2.exceptions.BadRequestException;
import Lesson20.task2.exceptions.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class Validate  {

    /**  сумма транзакций больше указаного лимита*/
    public static void   validateLimitSimpleTransactionAmount(Transaction transaction) throws Exception{
        if (transaction.getAmount() > TransactionDAO.utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + ". Can't be saved");
    }

    /**  сумма денег транзакций за день больше дневного лимита*/
    public static void validateTransactionsPerDay(Transaction transaction) throws Exception{
        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {//пробегаемся по всем транзакциям и
            //ищем их сумму
            sum += tr.getAmount();
            count++;
        }

        //если сумма денег в транзакциях за заданый день > дневной лимит транзакций(денег) за  день то кидаем ошибку
        if (sum > TransactionDAO.utils.getLimitTransactionsPerDayAmount()) {//
            throw new LimitExceeded("Transaction limit per day amount exceeded " + transaction.getId() + ". Can't be saved");
        }
        //если количество транзакций  > счетчик  лимитов транзакций за день  то кидаем ошибку
        if (count > TransactionDAO.utils.getLimitTransactionsPerDayCount()) {//
            throw new LimitExceeded("Transaction limit per day count exceeded " + transaction.getId() + ". Can't be saved");
        }
    }

    /**проверка свободных ячеек в хранилище*/
    public static void validateFreeSpaceInStorage (Transaction transaction) throws InternalServerException {

        int countnew = 0;
        for (Transaction tr : TransactionDAO.transactions) {
            if (tr != null)//если ячейка не налл то каунт ++
                countnew++;
            if (countnew > TransactionDAO.transactions.length - 1)
                throw new InternalServerException("No free space in storage " + tr.getId());
        }
    }

    public static Transaction validateCity(Transaction transaction) throws Exception {
        int a = 0;
        for (Transaction tr : TransactionDAO.transactions) {
            if (tr != null) {
                if (tr.getCity() == "Kiev" || tr.getCity() == "Odessa") {
                    throw new BadRequestException("Sity " + tr.getCity() + " not allowable ");
                }
            }
            if (tr == null) {
                TransactionDAO.transactions[a] = transaction;
                break;
            }
            a++;
        }
      return transaction;
    }


    /**  сумма (денег) транзакций за день больше дневного лимита*/
    // например днем было 3 тразакции по  30 едениц денег а у нас лимит стоит 100
    //мы делаем транзакцию на 20 получается 110 это значит что лимит дневной вышел и выдаем ошибку
    //нам нужно посчитать эту сумму, пробегаемся по всем транзакциям за текущий день
    //используем метод поиск транзакций за текущий день getTransactionsPerDay
    //передали методу дату транзакции которую мы хотим сохранить
    //таким образом мы получили все транзакции за день моей сохраняемой транзакции

    /** Метод ищет все транзакции за текущий день заданой даты*/
    private static Transaction[] getTransactionsPerDay(Date dateOfCurTransaction){
        //dateOfCurTransaction это входящая дата

        Calendar calendar = Calendar.getInstance();//создали объект Календарь
        calendar.setTime(dateOfCurTransaction);//записываем входящую  дату транзакции в календарь
        //(Просетили дату которая пришла как параметр)
        int month = calendar.get(Calendar.MONTH);//с календаря можно доставать месяц входящей даты
        int day = calendar.get(Calendar.DAY_OF_MONTH);// с календаря можно доставать день месяца входящей даты
        //пробегаем по массиву по всем транзакциям и из каждой транзакции достаем ее месяц и ее день
        int count = 0;
        for (Transaction transaction : TransactionDAO.transactions) {
            if (transaction != null){
                calendar.setTime(transaction.getDateCreated());//записали в календарь дату текущей транзакции из цикла
                int trMonth = calendar.get(Calendar.MONTH);//взяли месяц создания текущей транзакции
                int trDay = calendar.get(Calendar.DAY_OF_MONTH); //взяли число создания текущей транзакции
                //значения trMonth и trDay сравниваем с месяцем и днем нашей входящей даты
                if (trMonth == month && trDay == day)//если месяц и число входящей транзакции и транзакции из цикла
                    //совпадают то эта транзакция за текущий день и увеличиваем счетчик
                    //(считаем количество таких транзакций и заполняем ими массив result )

                    count++;
            }
        }
        //создаем массив result типа Transaction[]
        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : TransactionDAO.transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    result[index] = transaction;
                index++;
            }
        }
        return result;
    }
}
