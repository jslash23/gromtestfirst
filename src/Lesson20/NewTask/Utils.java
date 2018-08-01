package Lesson20.NewTask;

public class Utils   {
    private int limitTransactionsPerDayCount = 2;
    private int  limitTransactionsPerDayAmount = 100;
    private int limitSimpleTransactionAmount = 80;
    private String[] cities ={"Kiev","Odessa"};


    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public int getLimitSimpleTransactionAmount()  {
        return limitSimpleTransactionAmount;
    }

    public String[] getCities() {
        return cities;
    }

}
