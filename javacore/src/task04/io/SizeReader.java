package task04.io;

import java.util.Scanner;

/**
 * Класс создан для считывания с консоли целого, положительного числа, которое будет использовано в качестве размера массива.
 */

 public class SizeReader {

    /**
     * Метод считывает с консоли целое, положительное число и возвращает его.
     * @return - считанный размер массива.
     */

     public static int readSize() {

        Scanner scanner = new Scanner(System.in);

        int result = 0;

        // В цикле считывает строку, парсим ее в целочисленное значение.
        // Если число отрицательное/равно 0 вы брасываем исключение IllegalArgumentException.
        // в блоке catch ловим исключения, которые могли возникнуть во время парсинга или проверки числа.
        // Если выброс исключения не произошел присваиваем флагу needMore значение false и выходим из цикла.

        boolean needMore = true;
        while (needMore) {
            System.out.println("Введите целое число N, размер массива: ");
            String number = scanner.nextLine();
            try {
                result = Integer.parseInt(number);
                if (result <= 0) {
                    throw new IllegalArgumentException();
                }
                needMore = false;
            } catch (Exception e) {
                System.out.println("Вы ввели не корректное число, попробуйте еще раз");
            }

        }
       return result;

    }
}
