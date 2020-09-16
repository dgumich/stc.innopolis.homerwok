package task04.sorters;

import task04.person.Person;

import java.util.Comparator;


/**
 * Интерфейс классов сортировщиков с единственным методом - сорт.
 */

public interface Sorter {

    /**
     * Метод интерфейса принимает массив из объектов Person, которые необходимо отсортировать и компаратор для сортировки
     * @param persons - массив, который необходимо отсортировать, состоит из объектов Person
     * @param comparator - компаратор, который используется для сортировки массива
     * @return - метод возвращаетс отсортированный массив
     */
    Person[] sort(Person[] persons, Comparator<Person> comparator);

}
