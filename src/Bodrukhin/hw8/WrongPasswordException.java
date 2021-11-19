package hw8;
// Создал класс-исключение

public class WrongPasswordException extends Exception  {
    private String checkData;

    public WrongPasswordException() {
        checkData = "Ошибка регистрации пароля";
    }

    public WrongPasswordException(String message) {
        super(message);
        checkData = message;
    }

    @Override
    public String toString() {
        return  checkData;
    }

}
