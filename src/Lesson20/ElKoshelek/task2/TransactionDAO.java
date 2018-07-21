package Lesson20.ElKoshelek.task2;

import Lesson20.ElKoshelek.task2.exceptions.BadRequestException;
import Lesson20.ElKoshelek.task2.exceptions.InternalServerException;
import Lesson20.ElKoshelek.task2.exceptions.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {  //класс для работы с данными

    private  Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {
        if (transaction == null) {
            throw new BadRequestException("Detected null transactions in metod save");
        }

//  сумма транзакций больше указаного лимита +
//  сумма транзакций за день больше дневного лимита +
//  количество транзакций за день больше указаного лимита +
//  если город оплаты (совершения транзакции) не разрешен ошибка БедРеквестЭксепшн
//  не хватило места кидаем ошибку ИнтерналСерверЭксепшн, где нехватило места? Нехватило места в хранилище

        validate(transaction);

        return transaction;//возвращаем ту транзакцию которую сохранили в хранилище
    }

    private Transaction validate(Transaction transaction) throws Exception {

        /*/  сумма транзакций больше указаного лимита*/
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + ". Can't be saved");

        /*/  сумма денег транзакций за день больше дневного лимита*/

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            //пробегаемся по всем транзакциям и ищем их сумму
            sum += tr.getAmount();
            count++;
        }

        //если сумма денег в транзакциях за заданый день > дневной лимит транзакций(денег) за  день то кидаем ошибку
        if (sum > utils.getLimitTransactionsPerDayAmount()) {//
            throw new LimitExceeded("Transaction limit per day amount exceeded " + transaction.getId() + ". Can't be saved");
        }
        //если количество транзакций  > счетчик  лимитов транзакций за день  то кидаем ошибку
        if (count > utils.getLimitTransactionsPerDayCount()) {//
            throw new LimitExceeded("Transaction limit per day count exceeded " + transaction.getId() + ". Can't be saved");
        }

        /*/ проверка допустимых городов*/
        int a = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                if (tr.getCity().equals("Kiev")  || tr.getCity().equals("Odessa")) {
                    throw new BadRequestException("Sity " + tr.getCity() + " not allowable ");
                }
            }
            if (tr == null) {
                transactions[a] = transaction;
                break;
            }
            a++;
        }

        /*/ проверка свободных ячеек в хранилище*/

        int countnew = 0;
        for (Transaction tr : transactions) {
            if (tr != null)
                countnew++;
            if (countnew > transactions.length - 1)
                throw new InternalServerException("No free space in storage " + tr.getId());
        }

        return transaction;
    }

    /*/  сумма (денег) транзакций за день больше дневного лимита*/

    private  Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)

                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
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


    public Transaction[] transactionList() {

        int count = 0;
        for (Transaction transaction : transactions) {

            if (transaction != null) {
                while (count < transactions.length - 1)
                    count++;
            } else  {
                while (count < transactions.length - 1)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction == null) {
                while (index < transactions.length - 1) {
                    result[index] = null;
                    index++;
                }
            } else {
                while (index < transactions.length - 1) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }

    public Transaction[] transactionList(String city) {
        return null;
    }

    public Transaction[] transactionList(int amount) {
        return null;
    }
}

