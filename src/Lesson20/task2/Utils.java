package Lesson20.task2;

/**
 * Created by slash22 on 30.06.2018.
 */
public class Utils {
    private int limitTransactionsPerDayCount = 10;//счетчик  лимитов транзакций за день
    private int  limitTransactionsPerDayAmount = 100;//дневной лимит денег за день   точно
    private int limitSimpleTransactionAmount = 500;//указаный лимит  точно
    private String[] cities ={"Kiev","Odessa"};


    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public String[] getSities() {
        return cities;
    }
}
