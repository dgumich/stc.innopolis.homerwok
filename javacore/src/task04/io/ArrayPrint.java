package task04.io;

import task04.person.Person;

import java.util.Arrays;


/**
 * Класс, отвечающий за вывод в консоль отсортированных массивов типа Person
 */
public class ArrayPrint {

    /**
     * Метод принимает на вход массив с объектами типа Person, время начала/конца сортировки
     * и выводит эти данные в консоль
     * @param persons - массив, который необходимо вывести в консоль
     * @param start - время начала сортировки
     * @param stop - время конца сортировки
     */
    public static void print(Person[] persons, long start, long stop, String name) {

        //выводим отсортированный массив в консоль
        System.out.println();
        System.out.println(Arrays.toString(persons));
        System.out.println("================================================================================");
        //выводим время работы в миллисекундах в консоль
        System.out.println("Время работы метода " + name + " : " + (stop - start) / 1_000_000 + " мс");
        System.out.println();
        System.out.println();

    }

}
