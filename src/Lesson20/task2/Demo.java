package Lesson20.task2;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args)throws Exception {

        Transaction transaction1 = new Transaction(1,"Kiev",120,"popolnenie scheta mob",TransactionType.INCOME, new Date());
//Transaction(long id, String city, int amount, String description, TransactionType type, Date dateCreated)
        Transaction transaction2 = new Transaction(2,"Odessa",110,"popolnenie scheta mob",TransactionType.INCOME, new Date());
        Transaction transaction3 = new Transaction(5,"Harkov",50,"popolnenie scheta mob",TransactionType.OUTCOME, new Date());
        Transaction transaction4= new Transaction(0,"Zimbabve",10,"popolnenie scheta mob",TransactionType.OUTCOME, new Date());
        Transaction transaction5= new Transaction(15,"xz",20,"popolnenie scheta mob",TransactionType.OUTCOME, new Date());

        Transaction[] transactions = new Transaction[]{transaction1,transaction2,transaction3};
        Controller controller = new Controller();

        controller.save(transaction1);
        /*controller.save(transaction2);
        controller.save(transaction3);
        controller.save(transaction4);
        controller.save(transaction5);*/

        System.out.println(Arrays.toString(controller.transactionList()));

    }
}
