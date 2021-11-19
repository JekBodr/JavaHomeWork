package hw8;
// Создал класс-исключение

public class WrongLoginException extends Exception {
    private String checkData;

    public WrongLoginException() {
        checkData = "Ошибка регистрации логина";
    }

    public WrongLoginException(String message) {
        super(message);
        checkData = message;
    }
    @Override
    public String toString() {
        return  checkData;
    }
}



