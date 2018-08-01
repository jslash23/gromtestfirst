package Lesson20.NewTask;

import Lesson20.NewTask.exceptions.BadRequestException;
import Lesson20.NewTask.exceptions.InternalServerException;
import Lesson20.NewTask.exceptions.LimitExceeded;

import java.util.Calendar;
import java.util.Date;


public class TransactionDAO {

    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {
        if (transaction == null) {
            throw new BadRequestException("Detected null transactions in metod save");
        }


        validate(transaction);

        for (int ind = 0; ind < transactions.length; ind++) {
            if (transactions[ind] == null) {
                transactions[ind] = transaction;
                 return transactions[ind];
            }
        }
            throw new InternalServerException("No free space in storage " + transaction.getId());
    }

    private Transaction validate(Transaction transaction) throws Exception {
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {

            sum += tr.getAmount();
            count++;
        }

        if ((sum + transaction.getAmount()) > utils.getLimitTransactionsPerDayAmount() ) {//
            throw new LimitExceeded("Transaction limit per day amount exceeded " + transaction.getId() + ". Can't be saved");
        }

        if ((count + 1) > utils.getLimitTransactionsPerDayCount()) {//
            throw new LimitExceeded("Transaction limit per day count exceeded " + transaction.getId() + ". Can't be saved");
        }

        int countSity = 0;
        for (String cities : utils.getCities()) {


            if ((cities != null)&&(transaction.getCity().equalsIgnoreCase(cities))) {
                countSity++;
            }
        }
        if (countSity == 0) {
            throw new BadRequestException("Sity " + transaction.getCity() + " not allowable ");
        }

        return transaction;
    }


    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {

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

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }

    public Transaction[] transactionList() {

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

    public Transaction[] transactionList(Integer amount) {
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


