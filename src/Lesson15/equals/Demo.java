package Lesson15.equals;
//
public class Demo {
    public static void main(String[] args) {
        File file1 = new File(111, "home/Documents/test", "txt");
        File file2 = new File(111, "home/Documents/image", "jpg");
        File file3 = new File(111, "home/Documents/test", "txt");

        File someFile = file1;//здесь переменная someFile  ссылается на объект
        // (переменная есть ссылка на объект)
        // new File(111,"home/documents/test","txt") так же как и переменная file1
        // ссылается на этот же объект

        System.out.println(file1.equals(file2));//да
        System.out.println(file1.equals(file3));//нет

        System.out.println(file1.hashCode());
        System.out.println(file3.hashCode());
        System.out.println(file2.hashCode());
        System.out.println("pretest");
        System.out.println(file1.equals(file3));

        System.out.println(file1 == file3);//ссылки не равны(тут сравниваем две одинаковые ссылки)
        System.out.println(file1 == someFile);//ссылки равны (тут сравниваем две одинаковые ссылки)

        User user = new User(111);
        System.out.println("test");
        System.out.println(file1.equals(user));//файл1 сравниваем с юзером должно быть фалс т.к. другой объект

        //user1 == user2;
        //user1.getId() == user2.getId();

    }
}
