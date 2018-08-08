package Lesson22.arrays.el_koshelek_stat;

public class Utils   {
    private static int limitTransactionsPerDayCount = 2;
    private static int  limitTransactionsPerDayAmount = 100;
    private static int limitSimpleTransactionAmount = 80;
    private static String[] cities ={"Kiev","Odessa"};


    public static int  getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public static int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public static int getLimitSimpleTransactionAmount()  {
        return limitSimpleTransactionAmount;
    }

    public static String[] getCities() {
        return cities;
    }

}
