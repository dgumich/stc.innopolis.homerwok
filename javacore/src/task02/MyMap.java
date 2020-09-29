package task02;

import java.util.Objects;

/**
 * Класс - ассоциативный массив, упращенный аналог HashMap.
 * Предназначен для хранения данных в виде ключ - значение.
 * Тип ключа и данных - Object.
 */


class MyMap {

    /**
     * Дефолтный размер массива, в ячейках которого хранятся объекты Node
     * По умолчанию равен 32.
     */

    static final int DEFAULT_INITIAL_CAPACITY = 32;




    /**
     * Количество пар ключ-значение в объекте.
     */

    private int size;




    /**
     * Массив, для хранения односвязных списков, построенных из объектов класса Node (бакеты).
     * Инициализируется в конструкторе по умолчанию, с размером DEFAULT_INITIAL_CAPACITY;
     */

    Node[] table;




    /**
     * Внутренний клас, предназначенный для организации односвязного списка и хранения:
     * int hash - хэша ключа
     * Object key - ключа
     * Object value - переданного значения
     * Node next - ссылки на следующий объект типа Node.
     */

    static class Node {
        final int hash;
        final Object key;
        Object value;
        Node next;

        Node(int hash,Object key, Object value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }





        @Override
        public String toString() {
            return  key.toString() + "=" + value.toString();
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key.equals(node.key) &&
                    value.equals(node.value);
        }
    }


    public int getSize() {
        return this.size;
    }



    /**
     * Метод для вычисления целочисленного значения хэша ключа.
     * Взят из HashMap.
     * @param key - ключ типа Object, хэш которого нужно вычислить.
     * @return целочисленное значение хэша.
     */

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }



    public MyMap() {
        table = new Node[DEFAULT_INITIAL_CAPACITY];
        size = 0;

    }




    /**
     * Метод, с помощью которого можно узнать есть ли пары ключ-значения в объекте MyMap.
     * @return возращает boolean значение.
     */

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Метод принимает пару ключ-значение. На основании хэша ключа и длины массива с объектами Node вычисляется индекс
     * данного массива, где должна хранится входящая пара ключ-значение.
     * Ячейка массива с данным индексом проверяется на совпдаение по ключу.
     * Если совпадение есть - значение value в объекте Node перезаписывается на новое.
     * В случаи отсутствия совпданий ключа, создается новый объект Node, в который происходит сохранение данных.
     * В обоих случаях происходит инкрементирование переменной size.
     * @param key - значение ключа, типа Object
     * @param value - значение данных, тип Object
     * @return = возращаемые данные, типа Object. Если объект записано - возращается сам объект, если произошла
     * перезапись - возращается старое перезаписанное значение (по аналогии с HashMap).
     */

    public Object put(Object key, Object value) {
        int keyHash = hash(key);
        int index = (table.length - 1) & keyHash;

        //Проверка ячейки массива на наличие объектов, в случае отсутствия обектов - создание нового
        // вызовом конструктора и сохранения в нем ключа-значения

        if (table[index] == null) {
            table[index] = new Node(keyHash, key, value,null);
        } else {

            // Если в ячейке есть объект, то проверяется совпадение по хешу ключа и его значению.
            // В случае совпадения происходит перезапись значения

            Node current = table[index];
            Node next = current.next;
            if (keyHash == current.hash && current.key.equals(key)) {
                Object oldValue = current.value;
                current.value = value;
                return oldValue;
            } else {

                // Проход связанного списка и проверка совпадения ключа
                // При совпаднии - перезапись значения

                while (next != null) {
                    current = next;
                    next = current.next;
                    if (keyHash == current.hash && current.key.equals(key)) {
                        Object oldValue = current.value;
                        current.value = value;
                        return oldValue;
                    }
                }
                // Если после прохождения связанного списка, совпадений по ключу не было найдено,
                // создается новый объект, в который помещается пара ключ-значение и линкуется к последнему объекту Node.

                current.next = new Node(keyHash, key, value, null);
            }
        }
        size++;
        return value;
    }


    /**
     * Возвращает значние по ключу. В случае отсутсвия ключа метод возвращает null.
     * @param key - ключ типа Object, по которому происходит поиск данных
     * @return - значение, соответвущее данному ключу, тип данных - Object.
     */

    public Object get(Object key) {

        int keyHash = hash(key);

        // вычисление номера ячейки и проверка на пустоту.

        int index = keyHash & (table.length - 1);

        if (table[index] == null) {
            return null;
        } else {

            //Проход односвязного списка, на наличие совпадений по ключу

            Node current = table[index];
            Node next = current.next;
            if (keyHash == current.hash && current.key.equals(key)) {
                return current.value;
            } else {
                while (next != null) {
                    current = next;
                    next = current.next;
                    if (keyHash == current.hash && current.key.equals(key)) {
                        return current.value;
                    }
                }

            }

        }
        return null;

    }




    /**
     * Метод принимает ключ, по которому необходимо удалить данные.
     * Происходит вычисление хэша ключа, индекса в массиве table, соответсвующего данному ключу.
     * Объект/объекты типа Node, расположенные в данной ячейке, проверяются на совпадение ключа.
     * В случаи совпадения, если объект Node располагается в начале связанного списка, происходит переопределние
     * начала списка (ячейке массива присваивается следующий элемент). Если объект Node находится не в голове списка,
     * то происходит переопределение ссылки предыдущего объекта Node на следующий, исключая текущий.
     * @param key ключ, значение которого необходимо удалить.
     * @return возращаемое значение типа Object. В случаи успешного удаления метод возрашает удаленный объект,
     * если переданый ключ отсутсвует, то возращается null.
     */

    public Object remove(Object key) {
        // вычисление номера ячейки и проверка на пустоту.

        int keyHash = hash(key);
        int index = (table.length - 1) & keyHash;
        if (table[index] == null) {
            return null;
        } else {

            //Проход односвязного списка, на наличие совпадений по ключу

            Node current = table[index];
            Node next = current.next;

            if (keyHash == current.hash && current.key.equals(key)) {
                table[index] = current.next;
                size--;
                return current.value;
            } else {
                Node previous = current;
                while (next != null) {
                    current = next;
                    next = current.next;
                    if (keyHash == current.hash && current.key.equals(key)) {
                        previous.next = next;
                        size--;
                        return current.value;
                    }
                    previous = current;
                }
                return null;
            }
        }

    }




    /**
     * Метод производит проверку наличия элемента по ключу.
     * @param key - передаваемый ключ, тип Object.
     * @return метод возращает boolean переменную результата поиска по переданному ключу.
     */
    public boolean isValuePresent(Object key) {
        return get(key) != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        for (Node node : table) {
            if (node != null) {
                sb.append(node.toString());
                sb.append(" ");
                Node current = node;
                Node next = current.next;
                while (next != null) {
                    current = next;
                    next = current.next;
                    sb.append(current.toString());
                    sb.append(" ");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
