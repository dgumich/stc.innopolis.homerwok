package task04.sorters;

import task04.UserException;
import task04.person.Person;

import java.util.Comparator;
import java.util.HashSet;

/**
 * Компаратор для сравнения объектов Person;
 */

public class PersonComparator implements Comparator<Person> {

    /**
     * HashSet в который записываются исключения, которые возникили при совпадении имени и возраста
     */

    private static HashSet<String> exceptions = new HashSet<>();

    public static void setExceptions(HashSet<String> exceptions) {
        PersonComparator.exceptions = exceptions;
    }

    public static HashSet<String> getExceptions() {
        return exceptions;
    }

    /**
     * Переопределенный метод compare интерфейса Comparator. На вход принимает два объекта, типа Person
     * @param o1 - первый объект
     * @param o2 - второй объект
     *           После чего проверяет данные объекты сначала по параметру sex, затем по name и по age.
     *           В случае полного совпадения выбрасывается UserException, который тут же перехватывается и сохраняется
     *           в HashSet exception
     * @return возращает значение типа int.
     */
    @Override
    public int compare(Person o1, Person o2) {


        int result = o1.getSex().compareTo(o2.getSex());
        if (result == 0) {
            result = o1.getName().compareTo(o2.getName());
            if (result == 0) {
                result = o2.getAge() - o1.getAge();
                if (result == 0) {
                    try{
                        throw new UserException();
                    } catch (UserException e) {
                        exceptions.add((e.getMessage() + o1.toString()));
                    }

                }
                return result;
            } else {
                return result;
            }
        } else return result;
    }
}
