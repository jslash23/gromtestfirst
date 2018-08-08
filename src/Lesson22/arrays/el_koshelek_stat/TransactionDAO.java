package Lesson22.arrays.el_koshelek_stat;

import Lesson22.arrays.el_koshelek_stat.exceptions.BadRequestException;
import Lesson22.arrays.el_koshelek_stat.exceptions.InternalServerException;
import Lesson22.arrays.el_koshelek_stat.exceptions.LimitExceeded;

import java.util.Calendar;
import java.util.Date;


public class TransactionDAO {//класс для работы с данными

    private static Transaction[] transactions = new Transaction[10];
    //private Utils utils = new Utils();

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

        for (int ind = 0; ind < transactions.length; ind++) {
            if (transactions[ind] == null) {
                transactions[ind] = transaction;
                 return transactions[ind];//возвращаем  транзакцию
            }
        }
            throw new InternalServerException("No free space in storage " + transaction.getId());
    }

    private static Transaction validate(Transaction transaction) throws Exception {

        /*/  сумма транзакций больше указаного лимита*/
        if (transaction.getAmount() > Utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + ". Can't be saved");

        /*/  сумма денег в  транзакциях за день больше дневного лимита*/
        int sum = 0;
        int count = 0;

        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            //пробегаемся по всем транзакциям и ищем их сумму
            sum += tr.getAmount();
            count++;
        }

        //если сумма денег в транзакциях за заданый день > дневной лимит транзакций(денег) за день
        //то кидаем ошибку
        if ((sum + transaction.getAmount()) > Utils.getLimitTransactionsPerDayAmount() ) {//
          throw new LimitExceeded("Transaction limit per day amount exceeded "+transaction.getId() + "Can't be saved");
        }

        //если количество транзакций  > счетчик  лимитов транзакций за день  то кидаем ошибку
        if ((count + 1) > Utils.getLimitTransactionsPerDayCount()) {//
          throw new LimitExceeded("Transaction limit per day count exceeded "+transaction.getId() + "Can't be saved");
        }
         /*/ проверка допустимых городов*/
        int countSity = 0;
        for (String cities : Utils.getCities()) {

            if ((cities != null)&&(transaction.getCity().equalsIgnoreCase(cities))) {
                countSity++;
            }
        }
        if (countSity == 0) {
          throw new BadRequestException("Sity " + transaction.getCity() + transaction.getId() + " not allowable ");
        }

        return transaction;
    }

    //**  сумма (денег) транзакций за день больше дневного лимита**/
    private static Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {//dateOfCurTransaction это входящая дата


         /*Метод ищет все транзакции за текущий день заданой даты*/
        // например днем было 3 тразакции по  30 едениц денег а у нас лимит стоит 100
        //мы делаем транзакцию на 20 получается 110 это значит что лимит дневной вышел и выдаем ошибку
        //нам нужно посчитать эту сумму, пробегаемся по всем транзакциям за текущий день
        //используем метод поиск транзакций за текущий день getTransactionsPerDay
        //передали методу дату транзакции которую мы хотим сохранить
        //таким образом мы получили все транзакции за день моей сохраняемой транзакции

        Calendar calendar = Calendar.getInstance();//создали объект Календарь
        calendar.setTime(dateOfCurTransaction);//записываем входящую  дату транзакции в календарь
        //(Просетили дату которая пришла как параметр)

        int month = calendar.get(Calendar.MONTH);//с календаря можно доставать месяц входящей даты
        int day = calendar.get(Calendar.DAY_OF_MONTH);// с календаря можно доставать день месяца входящей даты

        int count = 0;
        for (Transaction transaction : transactions) {//пробегаем по массиву по всем транзакциям и из каждой
            // транзакции достаем ее месяц и ее день
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());//записали в календарь дату текущей транзакции из цикла
                int trMonth = calendar.get(Calendar.MONTH);//взяли месяц создания текущей транзакции
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);//взяли число создания текущей транзакции
                if (trMonth == month && trDay == day)//если месяц и число входящей транзакции и транзакции из цикла
                    //совпадают то эта транзакция за текущий день и увеличиваем счетчик
                    //(считаем количество таких транзакций и заполняем ими массив result )
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];//создаем массив result типа Transaction[]
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }

    public Transaction[] transactionList() {

      /* Метод должен  возвращать массив транзакций без налов. Если нет элементов - пустой массив.
        Модификатор доступа не забудь указать. И в методе не должно быть ничего лишнего
         при проверке  (да и во всем коде, как при итоговой сдачи проекта).
          У меня валидатор жестко ругался на саут.
          Тут массив транзакций которые мы обработали?*/

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

    public Transaction[] transactionList(String city) {

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getCity().equalsIgnoreCase(city)) {
                count++;
            }
        }

        Transaction[] resultn = new Transaction[count];
        if (count == 0){
            return resultn;
        }
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getCity().equalsIgnoreCase(city)) {
                resultn[index] = transaction;
                index++;
            }
        }
        return resultn;

    }

    public Transaction[] transactionList(int amount) {
        int countn = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getAmount() == amount) {
                countn++;
            }
        }

        Transaction[] resultn = new Transaction[countn];
        if (countn == 0){
            return resultn;
        }
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getAmount() == amount) {
                resultn[index] = transaction;
                index++;
            }
        }
        return resultn;
    }
}


