package task04.io;

import task04.person.Person;
import task04.sorters.FirstSorter;
import task04.sorters.PersonComparator;
import task04.sorters.SecondSorter;
import task04.sorters.Sorter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;


/**
 * Класс создан для сортировки и вывода на экран массива
 */

public class SortAndPrint {

    /**
     * Метод принимает на вход массив объектов Person, сортирует его двумя способами,
     * выводит отсортированные массивы, время, потраченное на сортировку,
     * а также исключения(повторы) которые возникли в ходе сортировки
     * @param persons - массив, который необходимо отсортировать и вывести в консоль
     */
    public static void sortAndPrintArray(Person[] persons) {

        //создаем компаратор, который будет использован для сортировки
        Comparator<Person> personComparator = new PersonComparator();

        //копируем переданный массив, что бы использовать копию для второго алгоритма
        Person[] personscopy = Arrays.copyOf(persons, persons.length);

        //запускаем первый алгоритм сортировки и фиксируем время работы
        Sorter first = new FirstSorter();
        Long startFirst = System.nanoTime();
        persons = first.sort(persons, personComparator);
        Long finishFist = System.nanoTime();


        //выводим отсортированный массив в консоль
        System.out.println();
        System.out.println(Arrays.toString(persons));
        System.out.println("================================================================================");
        //выводим время работы в миллисекундах в консоль
        System.out.println("Время работы метода Arrays.sort: " + (finishFist - startFirst) / 1_000_000 + " мс");



        System.out.println();
        System.out.println();

        //обнуляем HashSet с искоючениями, которые возникли во время сортировки первого массива.
        PersonComparator.setExceptions(new HashSet<String>());
        //запускаем второй алгоритм сортировки и фиксируем время работы
        Sorter second = new SecondSorter();

        Long startSecond = System.nanoTime();
        personscopy = second.sort(personscopy, personComparator);
        Long finishSecond = System.nanoTime();

        //выводим отсортированный массив в консоль
        System.out.println();
        System.out.println(Arrays.toString(personscopy));
        System.out.println("================================================================================");
        //выводим время работы в миллисекундах в консоль
        System.out.println("Время работы пузырьковой сортировки: " + (finishSecond - startSecond) / 1_000_000 + " мс");

        System.out.println();
        System.out.println();

        //выводим исключения-повторы имен и возраста
        System.out.println("Выброшенные и пойманные исключения UserException в первом и втором случае: ");
        for (String exception: PersonComparator.getExceptions()) {
            System.out.println(exception);
        }






    }

}
