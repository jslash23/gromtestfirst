package Lesson19;
//все делаем статичесским чтоб в майне заюзать
public class ThrowExample {
    private static String[] array = {"test", "test1", "tesqwd", null, "adsasf", "sdfsdf"};

    public static void main(String[] args) {
        //test();
        useOfTestMethod();
    }

    private static void test()throws RuntimeException {//проверяем массив на налл
        for (String element : array) {
            if (element == null)
                throw new RuntimeException("null is detected");
        }
        System.out.println("done");
    }

    private static void useOfTestMethod() {
        try {
            //some code
            test();
            //some code

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
