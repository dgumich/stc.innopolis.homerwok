package task04.logic;

import task04.io.ArrayPrint;
import task04.io.ExceptionPrint;
import task04.io.SizeReader;
import task04.person.Person;
import task04.person.PersonsGenerator;
import task04.sorters.FirstSorter;
import task04.sorters.PersonComparator;
import task04.sorters.SecondSorter;
import task04.sorters.Sorter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;


/**
 * Класс с логикой программы.
 */

public class ProgramLogic {

    /**
     * Метод принимает на вход массив объектов Person, сортирует его двумя способами,
     * выводит отсортированные массивы, время, потраченное на сортировку,
     * а также исключения(повторы) которые возникли в ходе сортировки
     */

    public void start() {

        //Считываем с консоли размер массива
        int size = SizeReader.readSize();

        //Генерируем массив, длины size
        Person[] persons = PersonsGenerator.generation(size);

        //копируем переданный массив, что бы использовать копию для второго алгоритма
        Person[] personscopy = Arrays.copyOf(persons, persons.length);

        //запускаем первый алгоритм сортировки и фиксируем время работы
        Sorter first = new FirstSorter();
        doSort(first, persons);

        //обнуляем HashSet с исключениями, которые возникли во время сортировки первого массива.
        PersonComparator.setExceptions(new HashSet<String>());

        //запускаем второй алгоритм сортировки и фиксируем время работы
        Sorter second = new SecondSorter();
        doSort(second, personscopy);

        //выводим исключения-повторы имен и возраста
        ExceptionPrint.print();


    }

    private void doSort(Sorter sorter, Person[] persons) {

        //создаем компаратор, который будет использован для сравнения
        Comparator<Person> personComparator = new PersonComparator();

        //сортируем и фиксируем время начала/финиша

        Long start = System.nanoTime();
        persons = sorter.sort(persons, personComparator);
        Long finish = System.nanoTime();

        //выводим отсортированный массив в консоль
        ArrayPrint.print(persons, start, finish, sorter.getClass().getSimpleName());

    }

}
