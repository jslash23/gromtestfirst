package Lesson15.equals;
//
public class File {

    private int size;
    private String path;
    private String extension;

    public File(int size, String path, String extension) {
        this.size = size;
        this.path = path;
        this.extension = extension;
    }

    //Здесь учитываем в объектах только поле path

    @Override
    public boolean equals(Object o) {

        //если ссылки равны (указывают на один и тот же объект) то возвращаем тру
        if (this == o) return true;//this это объект у которого вызываем метод


        if (o == null || getClass() != o.getClass())//Если объект налл или классы не совпадают
            //то вовращаем фолс
            return false;//Если классы разные то код не упадет

        File file = (File) o;//делаем операцию каст

        return size == file.size;
    }

    @Override
    public int hashCode() {
        return size;
    }

    /*@Override//переопределяем метод equals
    //сравниваем два объека по  по ссылкам
    public boolean equals(Object o) {
        if (this == o) return true;// this это тот объект у которого мы вызываем метод,
        // в данном случае это file1
        //если ссылки между собой равны (указывают на один и тот же объект) то мы возвращаем true

        if (o == null || getClass() != o.getClass()) return false;// если объект с которым мы
        // сравниваем налл  или классы не совпадают то возвращаем false


        File file = (File) o;//Делаем операцию кастом (Object тип  приводим к более узкому типу File)

        //Тут мы уже сравниваем поля
        if (!path.equals(file.path)) return false;//учитываем только поле path
        return true;
    }


    @Override
    public int hashCode() {
        return path.hashCode();
    }*/



    //Этот метод проверяет объекты по содержимому
    /*@Override
    public boolean equals(Object o) {
        if (this == o)//тут сравниваем ссылки объектов
            return true;//если ссылки указывают на один и тот же объект мы возвращаем тру
        if (o == null || getClass() != o.getClass())//если объект с которым мы сравниваем налл
            // или класы наших
            //объектов не совпадают (разные) то мы возвращаем false
            return false;

        File file = (File) o;//делаем операцию кастом объект типа обжект мы приводим к типу файл

        //Сравниваем поля
        if (size != file.size)// если поле size != полю size  другого объекта
            return false;// то возвращаем false
        if (!path.equals(file.path)) return false; // если поля path не равны между собой то возвр false
        if (!extension.equals(file.extension)) return false;//если поля extension не равны между собой
            // то возвращаем false
        return true; // если все проверки прошли то возвращаем true
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + path.hashCode();
        result = 31 * result + extension.hashCode();
        return result;
    }*/
}
