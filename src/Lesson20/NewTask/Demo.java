package Lesson20.NewTask;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args)throws Exception {

        Transaction transaction1 = new Transaction(1,"Kiev",5,"popolnenie scheta mob", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(2,"Odessa",10,"popolnenie scheta mob", TransactionType.INCOME, new Date());
        Transaction transaction3 = new Transaction(5,"Kiev",40,"popolnenie scheta mob", TransactionType.OUTCOME, new Date());
        Transaction transaction4= new Transaction(0,"Odessa",2,"popolnenie scheta mob", TransactionType.OUTCOME, new Date());
        Transaction transaction5= new Transaction(15,"Odessa",3,"popolnenie scheta mob", TransactionType.OUTCOME, new Date());

        Transaction[] transactions = new Transaction[]{transaction1,transaction2,transaction3,transaction4,transaction5};
        Controller controller = new Controller();
        System.out.println(controller.save(transaction1));
        System.out.println(controller.save(transaction2));
        System.out.println(" ");
        //controller.save(transaction3);
        //controller.save(transaction4);
        //System.out.println(controller.save(transaction5));


        System.out.println(Arrays.toString(controller.transactionList()));
        System.out.println(Arrays.toString(controller.transactionList("Kiev")));
        System.out.println(Arrays.toString(controller.transactionList(10)));
    }
}
