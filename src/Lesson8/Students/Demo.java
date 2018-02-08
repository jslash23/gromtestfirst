package Lesson8.Students;

/**
 Создайте следующую иерархию классов.

 Класс Course, поля:
 Date startDate
 String name
 int hoursDuration
 String teacherName
 Student[] students

 Должен содержать конструктов со всеми полями

 Класс Student с полями:
 String firstName
 String lastName
 int group
 Course[] coursesTaken
 int age

 У класса должен быть конструктор:
 firstName, lastName, group, coursesTaken

 Класс CollegeStudent, который является наследником Student
 У этого класса есть ряд дополнительных полей
 String collegeName
 int rating
 long id

 И два конструктора, один такой же как у Student и один со всеми полями текущего класса

 И наконец, класс SpecialStudent, который есть наследником CollegeStudent
 У него тоже есть дополнительные поля:
 long secretKey
 String email

 И конструктор со всеми полями (выберите конструктор CollegeStudent с меньшим количеством полей)

 В классе Demo создайте два метода: createHighestParent, createLowestChild который создают и
 возвращают Объекты самого высокого родителя и самого низкого наследника в данной иерархии

 */
public class Demo {

    public static Student createHighestParent() {
        Course[] courses = new Course[]{};
        //ТЕСТИРОВАНИЕ
        //Обычная проверка+
        //Проверка если есть налы+

        Student student1 = new Student("egor", "letov", 20, courses);
        Student[] students = new Student[]{student1};
        return  student1;
    }

    public static Student createHighestParent1() {
        Course[] courses = new Course[]{};
        Student student2 = new Student(null, null, 20, courses);
        Student[] students = new Student[]{student2};
        return  student2;
    }

    public static SpecialStudent createLowestChild() {

        Course[] courses = new Course[]{};
        SpecialStudent specialStudent1 = new SpecialStudent("Andrew", "Ivanov",
                25, courses, 2471, "javalesson@ukr.net");
        SpecialStudent[] specialStudents = new SpecialStudent[]{specialStudent1};
        return specialStudent1;
    }
    public static SpecialStudent createLowestChild1() {

        Course[] courses = new Course[]{};
        SpecialStudent specialStudent1 = new SpecialStudent(null, "Ivanov",
                25, null, 2471, "javalesson@ukr.net");
        SpecialStudent[] specialStudents = new SpecialStudent[]{specialStudent1};
        return specialStudent1;
    }

    public static void main(String[] args) {
        System.out.println(createHighestParent());
        System.out.println(createHighestParent1());
        System.out.println(createLowestChild());
        System.out.println(createLowestChild1());
    }
}
