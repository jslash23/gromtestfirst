package Lesson20.task2;

import Lesson20.task2.exceptions.BadRequestException;
import Lesson20.task2.exceptions.InternalServerException;
import Lesson20.task2.exceptions.LimitExceeded;

import java.util.Calendar;
import java.util.Date;


public class TransactionDAO {  //класс для работы с данными

    private  Transaction[] transactions = new Transaction[10];
    private  Utils utils = new Utils();

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
            if (tr != null)//если ячейка не налл то каунт ++
                countnew++;
            if (countnew > transactions.length - 1)
                throw new InternalServerException("No free space in storage " + tr.getId());
        }

        return transaction;
    }

    /*/  сумма (денег) транзакций за день больше дневного лимита*/

    /*Метод ищет все транзакции за текущий день заданой даты*/
    // например днем было 3 тразакции по  30 едениц денег а у нас лимит стоит 100
    //мы делаем транзакцию на 20 получается 110 это значит что лимит дневной вышел и выдаем ошибку
    //нам нужно посчитать эту сумму, пробегаемся по всем транзакциям за текущий день
    //используем метод поиск транзакций за текущий день getTransactionsPerDay
    //передали методу дату транзакции которую мы хотим сохранить
    //таким образом мы получили все транзакции за день моей сохраняемой транзакции

    private  Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        //dateOfCurTransaction это входящая дата

        Calendar calendar = Calendar.getInstance();//создали объект Календарь
        calendar.setTime(dateOfCurTransaction);//записываем входящую  дату транзакции в календарь
        //(Просетили дату которая пришла как параметр)
        int month = calendar.get(Calendar.MONTH);//с календаря можно доставать месяц входящей даты
        int day = calendar.get(Calendar.DAY_OF_MONTH);// с календаря можно доставать день месяца входящей даты
        //пробегаем по массиву по всем транзакциям и из каждой транзакции достаем ее месяц и ее день
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
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
       /*
       Возвращать массив транзакций без налов. Если нет элементов - пустой массив.
        Модификатор доступа не забудь указать. И в методе не должно быть ничего лишнего
         при проверке  (да и во всем коде, как при итоговой сдачи проекта).
          У меня валидатор жестко ругался на саут.
        */

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

