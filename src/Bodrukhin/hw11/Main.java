package hw11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scan = new Scanner(System.in);
        System.out.println("""
                Добавить контакт нажимайте   1
                Найти контакт нажимайте 2
                Удалить контакт нажимайте  3
                Просмотреть контакт нажимайте 4
                Сортировать контакт по ФИО нажимайте 5
                Сортировать контакт по дате рождения нажимайте 6
                Редактировать контакт  нажимайте 7
                Вывести  список в JSON нажимайте 8
                Записать в книгу в JSON нажимайте 9
                Для выхода нажимайте 0
                """);
        int userData;
        userData = scan.nextInt();
        boolean run = true;
        while (run) {
            switch (userData) {
                case 1 -> {
                    phoneBook.Add();
                    System.out.println("Введите новый запрос: ");
                    userData = Integer.parseInt(scan.nextLine());
                }
                case 2 -> {
                    System.out.println(phoneBook.Search());
                    System.out.println("Введите новый запрос: ");
                    userData = Integer.parseInt(scan.nextLine());
                }
                case 3 -> {
                    phoneBook.Remove();
                    System.out.println("Введите новый запрос: ");
                    userData = Integer.parseInt(scan.nextLine());
                }
                case 4 -> {
                    phoneBook.Modify();
                    System.out.println("Введите новый запрос: ");
                    userData = Integer.parseInt(scan.nextLine());
                }
                case 5 -> {
                    System.out.println(phoneBook.showPhoneBook());
                    System.out.println("Введите новый запрос: ");
                    userData = Integer.parseInt(scan.nextLine());
                }
                case 6 -> {
                    System.out.println(phoneBook.SortByName());
                    System.out.println("Введите новый запрос: ");
                    userData = Integer.parseInt(scan.nextLine());
                }
                case 7 -> {
                    System.out.println(phoneBook.SortByDateOfBirth());
                    System.out.println("Введите новый запрос: ");
                    userData = Integer.parseInt(scan.nextLine());
                }
                case 8 -> {
                    phoneBook.toFile();
                    System.out.println("Введите новый запрос: ");
                    userData = Integer.parseInt(scan.nextLine());
                }
                case 9 -> {
                    phoneBook.fromFile();
                    userData = Integer.parseInt(scan.nextLine());
                }
                case 0 -> {
                    run = false;
                    System.out.println("До встречи!");
                }
                default -> {
                    System.out.println("Неверный запрос. Попробуйте снова.");
                    userData = Integer.parseInt(scan.nextLine());
                }
            }
        }
    }
}
