package hw8;
/*
 * Работа с исключениями Try_catch, trow
 *@Author Bodrukhin Yevhen
 * version 1.0.0
 */
import java.util.Scanner;

public class OnlineShop {

    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        Auth auth = new Auth();
        Scanner scanner = new Scanner(System.in);

        // Проверяет соответствие вводимого пароля при регистарации
        // на сайте: для проверки соответствия пароля использовал регулярные выражения
        try {
            System.out.println("Регистрацисрация на сайте" + "\nПридумайте логин:");
            String login = scanner.nextLine();
            System.out.println("Пароль:");
            String password = scanner.nextLine();
            System.out.println("Повторите пароль:");
            String confirmPassword = scanner.nextLine();
            auth.signUP(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
        }

        // Проверяет соответствие зарегистрированого и вводимого паролей  при   авторизации
        // на сайте: сравнивает приватные строки класса Auth, и вводимые пользователем данные
        try {
            System.out.println("______________________" + "\nАвторизация на сайте" + "\nЛогин:");
            String checkLogin = scanner.nextLine();
            System.out.println("Пароль:");
            String checkPassword = scanner.nextLine();
            auth.signIn(checkLogin, checkPassword);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}



