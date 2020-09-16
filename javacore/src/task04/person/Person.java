package task04.person;


/**
 * Класс который представляет абстрактного человека.
 * Имеет три параметра: пол (sex), тип Sex; возраст(age) типа int; имя (name) типа String;
 */
public class Person {

    private final Sex sex;
    private final int age;
    private final String name;

    /**
     * Конструктор класса, на вход принимает три параметра
     * @param name - имя, тип String
     * @param sex - пол, тип boolean. Если значение true - создается мужчина, если false - женщина
     * @param age - возраст, тип инт
     *
     */

    Person (String name, boolean sex, int age) {
        this.age = age;
        if (sex) {
            this.sex = Sex.MAN;
        } else {
            this.sex = Sex.WOMAN;
        }
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "sex=" + sex +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
