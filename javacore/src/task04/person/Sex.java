package task04.person;

/**
 * Класс-перечисление описывающий пол человека (мужской или женский)
 * с парметром sex типа String
 */


public enum Sex {
    MAN("Man"), WOMAN("Woman");

    private final String sex;


    Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
