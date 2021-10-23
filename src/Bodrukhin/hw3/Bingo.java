package hw3;

import java.util.Scanner;

public class Bingo {
    static int attempt;
    static int programNumber;
    static int clientNumber;
    static int breakNumber;
    static int maxAttempts;
    static Scanner scanner;

    public static void main(String[] args) {
       initVars();
       findResult();
    }

    private static void initVars() {
        System.out.println("Угадайте число от 1 до 100");
        System.out.println("Для выхода из программы введите - 999.");
        maxAttempts = 99;
        attempt = 0;
        programNumber = 51;
        breakNumber =999;
        scanner = new Scanner(System.in);
    }

    private static void findResult() {
        while (attempt < maxAttempts){
            attempt++;
            System.out.println("Попытка " + attempt + ":");
            clientNumber = scanner.nextInt();
            if (clientNumber == programNumber){
                System.out.println("Поздравляю, Вы угадали число с: " + attempt + "й попытки" );
                break;
            }
            if (clientNumber != programNumber && clientNumber != breakNumber){
                if (clientNumber > programNumber){
                    System.out.println("Ваше число больше, попробуйте еще раз");
                }
                else {
                    System.out.println("Ваше число меньше, попробуйте еще раз");
                }
                continue;
            }
            if (clientNumber == breakNumber)
            System.out.println("Спасибо за игру, до встречи!");
            break;
        }
    }
}

