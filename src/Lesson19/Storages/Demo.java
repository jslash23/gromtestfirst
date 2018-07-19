package Lesson19.Storages;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {



        File file = new File(45, "File", ".txt", 10);
        File file1 = new File(1, "File1", ".txt", 10);
        File file2 = new File(2, "File2", ".txt", 10);

        File file3 = new File(78, "File", ".txt", 10);
        File file4 = new File(5, "File1", ".txt", 10);
        File file5 = new File(8, "File2", ".txt", 10);

        Storage storage = new Storage(1, new File[5], new String[]{".txt", ".jpg"}, "Country", 159);
        Storage storage2 = new Storage(2, new File[5], new String[]{".txt" }, "Country", 159);
        Storage storage3 = new Storage(3, new File[5], new String[]{".txt" }, "Country", 2040);

        Controller controller = new Controller();

        //controller.put(storage, file);
       // controller.put(storage, file1);
       // controller.put(storage, file2);

        controller.put(storage2, file);//id 45 txt
        controller.put(storage2, file1);//id 1 txt
        controller.put(storage2, file2);//jpg
        controller.put(storage2, file3);//id78 +
        controller.put(storage2, file4);//id 5 +
        controller.put(storage2, file5);//id 8

        //controller.put(storage3, file);
        //controller.put(storage3, file1);
        //controller.put(storage3, file2);

        System.out.println("1 " + storage);
        System.out.println("2 "+ storage2);
        System.out.println("3 "+ storage3);

        controller.transferAll(storage2, storage3);
        System.out.println("transferAll  " + storage3);
    }
}

