package Lesson16;

import java.util.Arrays;

/**
 * Created by slash22 on 23.03.2018.
 */
public class StringCompare {
    public static void main(String[] args) {

        System.out.println(new String("abc") == new String("abc"));//тут фолс потому что ссылки разные
        System.out.println(new String("abc").equals(new String("abc")));
        System.out.println("abc" == "abc");//тут сравнение ссылок
        System.out.println("abc".equals("Abc"));//тут сравнение самих объектов
        String s1 = "test";//Эти две переменные ссылаются на один кусок памяти который хранится в стринг пуле
        String s2 = "test";
        System.out.println(s1 == s2);
        //Стринг пул это область памяти куда попадают все стринги созданные не через ключевое слово new и
        //JVM проверяет есть ли в стринг пуле точно такой же стринг, если да то новая память в
        // стринг пуле не выделяется, потому что нет необходимости. Это сделано для более разионального
        // использования ресурсов памяти. Соответственно это один и тот же объект будет в памяти, две
        //разные ссылки (System.out.println("abc" == "abc");//тут сравнение ссылок) и тут вернется тру
        //Если ссылки разные то для стрингов это тру а для объектов фолс.


        //При сравнении стрингов лучше использовать Иквалс а не ==, потому что Иквлс дает возможность работы
        //с ключевым словом new.Все объекты сложных типов принято сравнивать через оператор Иквлс а не через ==
        //User user1 = new User();//Тут выделяется память под юзера
        //User user2 = new User ();//Тут выделяется память под юзера

        //Использование intern

        String s3 = new String("pppp");
        String s4 = "pppp";
        System.out.println(s3 == s4);

        s3 = s3.intern();//добавляем s3 в стрингпул
        System.out.println(s3 == s4);

        //bytes of String[]
        String str = "testStringVar";
        System.out.println(Arrays.toString(str.getBytes()));
        System.out.println((new String(str.getBytes())));
    }
}
/*//Внутреняя реализация самого метода внутри метода Иквлс(на иквлс  нажимаем с Ctrl)
public boolean equals(Object anObject) {//тут оверайдится оригинальный иквлс у обжект класса
        if (this == anObject) {//если ссылки одинаковые то тру
            return true;
        }
        if (anObject instanceof String) {//если разные то инстанс оф и  проверка по чарам
            String anotherString = (String)anObject;//идея проверки:  два стринга являются равными между собой
            int n = value.length;//если каждый чар раный между собой
            if (n == anotherString.value.length) {
                char v1[] = value;//разбиваем стринг  на чары
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {и проверяем их равенство (если каждый чар одного
                /массива равен каждому чару другого массива то тру иначе фолс )
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;
            }
        }
        return false;//если условие не выполняется то фолс
    }
*/

