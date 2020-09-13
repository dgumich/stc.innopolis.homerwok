package task02;


public class Main {
    public static void main(String[] args) {

        MyMap myMap = new MyMap();
        myMap.put(1, "one");
        myMap.put(2, "two");
        myMap.put(3, "three");
        myMap.put(4, "four");
        myMap.put(40,"fourty");
        myMap.put(41,"fourtyone");
        myMap.put(11,"eleven");
        myMap.put(10,"ten");
        myMap.put(8,"eight");
        myMap.put(56,"fiftysix");

        System.out.println("Содержимое myMap:");
        System.out.println(myMap);
        System.out.println();

        myMap.put(40,"fourtyUPD");

        System.out.println("Содержимое myMap после апдейта по ключу 40: ");
        System.out.println(myMap);
        System.out.println();

        System.out.println("Количество пар ключ-значение: ");
        System.out.println(myMap.getSize());
        System.out.println();

        myMap.remove(40);

        System.out.println("Содержимое myMap после удаления пл ключу 40: ");
        System.out.println(myMap);
        System.out.println();

        System.out.println("Количество пар ключ-значение: ");
        System.out.println(myMap.getSize());
        System.out.println();

        System.out.println("Получение элемента по ключу 11: ");
        System.out.println(myMap.get(11).toString());
        System.out.println();

        System.out.println("Проверка на наличие данного ключа (11): ");
        System.out.println(myMap.isValuePresent(11));
        System.out.println();

        System.out.println("Проверка на наличие данного ключа (11), после удаления: ");
        myMap.remove(11);
        System.out.println(myMap.isValuePresent(11));







    }
}
