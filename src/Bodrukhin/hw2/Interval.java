package Bodrukhin.hw2;/*
 * выбор диапазона числа с помощью if-else
 *@Author Bodrukhin Ievgen
 * version 1.0.0
 */

import java.util.Scanner;

public class Interval {
//Декларация переменной для приема данных от пользователя
    static int getNumber;

    public static void main(String[] args) {
//инициализация переменной при помощи Scanner
        initVars();
//метод с логическим оператором If else, в зависимости
        checkNumber();
    }

    private static void initVars() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        getNumber = sc.nextInt();
    }

    private static void checkNumber() {
        if (getNumber >= 0 && getNumber <= 14) {
            System.out.println("Вы ввели цифру от 0 до 14");
        }
        else if (getNumber >= 15 && getNumber <= 35) {
            System.out.println("Вы ввели цифру от 15 до 35");
        }
        else if (getNumber >= 35 && getNumber <= 50) {
            System.out.println("Вы ввели цифру от 35 до 50");
        }
        else if (getNumber >= 50 && getNumber <= 100) {
            System.out.println("Вы ввели цифру от 50 до 100");
        }
        else {
            System.out.println("Вы ввели данные вне диапазона");
        }
    }
}

