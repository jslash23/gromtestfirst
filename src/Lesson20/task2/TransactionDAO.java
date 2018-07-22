package Lesson20.task2;

import Lesson20.task2.exceptions.BadRequestException;
import Lesson20.task2.exceptions.InternalServerException;
import Lesson20.task2.exceptions.LimitExceeded;

import java.util.Calendar;
import java.util.Date;


public class TransactionDAO {  //класс для работы с данными

    private Transaction[] transactions = new Transaction[10];
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
        if (sum > utils.getLimitTransactionsPerDayAmount() + transaction.getAmount()) {//
            throw new LimitExceeded("Transaction limit per day amount exceeded " + transaction.getId() + ". Can't be saved");
        }
        //если количество транзакций  > счетчик  лимитов транзакций за день  то кидаем ошибку
        if (count > utils.getLimitTransactionsPerDayCount()) {//
            throw new LimitExceeded("Transaction limit per day count exceeded " + transaction.getId() + ". Can't be saved");
        }

        /*/ проверка допустимых городов*/
        int countn = 0;
        for (String cities : utils.getCities()) {
            if (cities != null) {
                if (transaction.getCity().equalsIgnoreCase(cities)) {
                    throw new BadRequestException("Sity " + cities + " not allowable ");
                }
            }
            if (cities == null) {
                transactions[countn] = transaction;
                break;
            }
            countn++;
        }

        /*/ проверка свободных ячеек в хранилище*/
        int countm =0;
        for (int a = 0; a < transactions.length; a++) {
            if (transactions[a] == null) {//если ячейка  налл то a++
                 countm ++;
            }
            if (countm == 0)
            throw new InternalServerException("No free space in storage " + transactions[a].getId());
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

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
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


    public Transaction[] transactionList()  {
       /*
       Метод должен  возвращать массив транзакций без налов. Если нет элементов - пустой массив.
        Модификатор доступа не забудь указать. И в методе не должно быть ничего лишнего
         при проверке  (да и во всем коде, как при итоговой сдачи проекта).
          У меня валидатор жестко ругался на саут.
          Тут массив транзакций которые мы обработали?
        */

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null)
                count++;
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                result[index] = transaction;
                index++;
            }
        }
        return result;
    }

    public Transaction[] transactionList(String city)  {

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getCity().equalsIgnoreCase(city)) {
                count++;
            }
        }

        Transaction[] resultn = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getCity().equalsIgnoreCase(city)) {
                resultn[index] = transaction;
                index++;//проверить
            }
        }
        return resultn;

    }

        public Transaction[] transactionList(Integer amount)  {
            int countn = 0;
            for (Transaction transaction : transactions) {
                if (transaction != null && transaction.getAmount() == amount) {//почему equals не катит?
                    countn++;
                }
            }

            Transaction[] resultn = new Transaction[countn];
            int index = 0;
            for (Transaction transaction : transactions) {
                if (transaction != null && transaction.getAmount()== amount) {
                    resultn[index] = transaction;
                    index++;
                }
            }
            return resultn;
        }
    }


