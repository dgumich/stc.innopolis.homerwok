package task04.sorters;

import task04.person.Person;

import java.util.Comparator;


/**
 * Класс для реализации пузырьковой сортировки
 */

public class SecondSorter implements Sorter  {

    /**
     *
     * @param persons - массив, который необходимо отсортировать, состоит из объектов Person
     * @param comparator - компаратор, который используется для сортировки массива
     *                   Метод использует пузырьковый метод для сортировки переданного массива.
     * @return метод возвращает отсортированный массив.
     */

    @Override
    public Person[] sort(Person[] persons, Comparator<Person> comparator) {
        Person temp;
        boolean sorted = true;
        for (int i = 0; i < persons.length; i++) {

            // в процессе сортировки выводится информация о количестве пройденного массива

            if (i == persons.length / 4) {
                System.out.println("Working... 25% is done");
            }
            if (i == persons.length / 2) {
                System.out.println("Working... 50% is done");
            }
            if (i == (persons.length * 3) / 4) {
                System.out.println("Working... 75% is done");
            }
            for (int j = i + 1; j < persons.length; j++) {

                if (comparator.compare(persons[i],persons[j]) > 0) {
                    temp = persons[i];
                    persons[i] = persons[j];
                    persons[j] = temp;
                }
            }
        }
        return persons;
    }
}
