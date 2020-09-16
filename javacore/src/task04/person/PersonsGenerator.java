package task04.person;


import java.util.Random;


/**
 * Класс для создания и заполнения массива объектами типа Person
 */

public class PersonsGenerator {

    /**
     * Метод принимает на вход размер массива, который необходимо создать.
     * @param n - размер массива, который необходимо создать.
     * @return - возвращаемый массив объектов Person.
     */

    public static Person[] generation(int n){
        Random random = new Random();

        //создаем два массива типа String с мужскими и женскими именами, которые будем использовать для создания объектов Person

        String [] manNames = {"Дмитрий","Александр","Василий","Алексей","Илья","Станислав","Григорий","Пётр","Роман","Константин","Владимир","Максим"};
        String [] womanNames = {"Вера","Татьяна","Александра","Елена","Светлана","Мария","Анастасия","Дарья","Юлия","Дарина","Екатерина","Ольга","Ирина","Антонина"};

        //создаем массив длиной n
        Person[] result = new Person[n];

        //Заполняем массив объектами типа Person.
        // Для этого сначала генерируем случайное значение типа boolean. При генерации true - создаем мужчину, false = женщину.

        for (int i = 0; i < result.length; i++) {
            if (random.nextBoolean()) {

                //имена случайно выбираем из массивов имен. Генерируем случайны возраст в диапазоне от 1 до 100.

                result[i] = new Person(manNames[(int)(random.nextDouble() * manNames.length)], true, ((int)(random.nextDouble() * 100) + 1));
            } else {
                result[i] = new Person(womanNames[(int)(random.nextDouble() * womanNames.length)], false, ((int)(random.nextDouble() * 100) + 1));
            }

        }
        return result;
    }

}
