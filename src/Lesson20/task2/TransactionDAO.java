package Lesson20.task2;

import Lesson20.task2.exceptions.BadRequestException;
import Lesson20.task2.exceptions.LimitExceeded;

import java.util.Calendar;
import java.util.Date;


public class TransactionDAO {  //класс для работы с данными

    public static Transaction[] transactions = new Transaction[10];
    public static Utils utils = new Utils();

   public Transaction save(Transaction transaction ) throws Exception {
       if (transaction == null) {
           throw new BadRequestException("Detected null transactions in metod save");
       }

//  сумма транзакций больше указаного лимита +
//  сумма транзакций за день больше дневного лимита +
//  количество транзакций за день больше указаного лимита +
//  если город оплаты (совершения транзакции) не разрешен ошибка БедРеквестЭксепшн
//  не хватило места кидаем ошибку ИнтерналСерверЭксепшн, где нехватило места? Нехватило места в хранилище
       //validate(transaction);


       /*  сумма транзакций больше указаного лимита*/
       Validate.validateLimitSimpleTransactionAmount(transaction);

        /*  сумма денег транзакций за день больше дневного лимита*/

       Validate.validateTransactionsPerDay(transaction);

       Validate.validateCity(transaction);

       Validate.validateFreeSpaceInStorage(transaction);
       //TODO
       return transaction;//возвращаем ту транзакцию которую сохранили в хранилище
   }


   public Transaction[]  transactionList() {
       /*
       Возвращать массив транзакций без налов. Если нет элементов - пустой массив.
        Модификатор доступа не забудь указать. И в методе не должно быть ничего лишнего
         при проверке  (да и во всем коде, как при итоговой сдачи проекта).
          У меня валидатор жестко ругался на саут.
        */

       int count =0;
        for (Transaction transaction : transactions) {

           if (transaction != null) {
              while (count < transactions.length-1)
                  count++;
           }

           else if (transaction == null) {
               while (count < transactions.length-1)
                   count++;
           }
        }

       Transaction[] result = new Transaction[count];
       int index = 0;
       for (Transaction transaction : transactions) {
           if (transaction == null) {
               while (index < transactions.length-1){
                result[index] = null;
                index++;
               }
           }

           else if (transaction != null){
               while (index < transactions.length-1) {
                   result[index] = transaction;
                   index++;
               }
           }
       }
       return result;
   }

    public Transaction[] transactionList(String city){
        return null;
    }

   public Transaction[] transactionList(int amount){
        return null;
    }



}
