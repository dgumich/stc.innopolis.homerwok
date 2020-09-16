package task04;

/**
 * Пользовательский класс-исключение (Uncheked)
 * выбрасывается на совпадение имени и возраста.
 */

public class UserException extends RuntimeException {

    public UserException(){
        super("Exception was thrown and caught! Одинаковые имена и возраст: ");
    }
}
