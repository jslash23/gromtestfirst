package Lesson15.cast;

/**
 * Created by slash22 on 20.11.2017.
 */
public class InstanceOfDemo {
    public static void main(String[] args) {
        Provider provider = new Provider();
        InternetProvider internetProvider = new InternetProvider();
        FoodProvider foodProvider = new FoodProvider();

        // instanceof оператор который возвращает
        //труе или фолс и он определяет принадлежность объекта к конкретному классу
        //это используется когда есть иерархия кода и мы не уверены что в каком то
        // куске кода текущий объект будет объектом нужного нам класса или нет


        System.out.println(provider instanceof Provider);// тут у объектов одинаковые классы

        System.out.println(provider instanceof InternetProvider);//нет он находится в иерархии Provider а
        //InternetProvider наследуется от Provider а не наоборот (provider выше чем InternetProvider)

        System.out.println( foodProvider instanceof Provider );//true foodProvider принадлежит к  Provider
        System.out.println(internetProvider instanceof Provider);//true  internetProvider находится в иерархии  Provider


        //System.out.println((FoodProvider)test());//  разные классы хоть и общий родитель
        //а мы можем приводить только высший к низшему
        //Операция Cast это приведение более широкого типа объектов к более узкому типу объектов
        // каст делает от общего родителя к более низкому уровню


        if (test() instanceof InternetProvider){
            System.out.println(test());// аналогично System.out.println((InternetProvider)test());
            //джава зает что это объект класса InternetProvider
        }
        else  if (test() instanceof FoodProvider){
            System.out.println(test());// аналогично System.out.println((FoodProvider)test());// аналогично
            // джава зает что это объект класса FoodProvider
        }

    }

    private static Provider test(){
        //logic

        return  new InternetProvider();
        //return new FoodProvider();
    }
}
