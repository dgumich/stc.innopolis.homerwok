package task04.io;

import task04.sorters.PersonComparator;

public class ExceptionPrint {

    public static void print() {

        //выводим исключения-повторы имен и возраста
        System.out.println("Выброшенные и пойманные исключения UserException в первом и втором случае: ");
        for (String exception: PersonComparator.getExceptions()) {
            System.out.println(exception);
        }
    }
}
