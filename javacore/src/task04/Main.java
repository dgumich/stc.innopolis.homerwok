package task04;

import task04.io.SizeReader;
import task04.io.SortAndPrint;
import task04.person.Person;
import task04.person.PersonsGenerator;


public class Main {
    public static void main(String[] args) {

        //Считываем с консоли размер массива


        int size = SizeReader.readSize();

        //Генерируем массив, длины size
        Person[] persons = PersonsGenerator.generation(size);

        //Передаем массив для сортировки и вывода на экран
        SortAndPrint.sortAndPrintArray(persons);


    }
}
