package task04.sorters;

import task04.person.Person;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс для реализации сортировки Arrays.sort
 */

public class FirstSorter implements Sorter {

    /**
     *
     * @param persons - массив, который необходимо отсортировать, состоит из объектов Person
     * @param comparator - компаратор, который используется для сортировки массива.
     *                   Метод вызывает метод Arrays.sort для переданного массива с заданным компаратором.
     * @return - отсортированный массив.
     */

    @Override
    public Person[] sort(Person[] persons, Comparator<Person> comparator) {
        Arrays.sort(persons,comparator);
        return persons;
    }
}
