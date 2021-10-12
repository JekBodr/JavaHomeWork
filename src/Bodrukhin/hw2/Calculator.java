package Bodrukhin.hw2;/*
 * Калькулятор
 *@Author Bodrukhin Ievgen
 * version 1.0.0
 */

import java.util.Scanner;

public class Calculator {
   //Декларирую переменную которая будет выведена в консоль
    static double result;

    //в main вызываю методы объявления переменных, вывода результата в консоль
    public static void main(String[] args) {
        initVars();
        showResult();
    }
   // Метод декларации переменных
    private static void initVars() {
        int operand1 = getNumber();
        int operand2 = getNumber();
        char sign =  getOperation();
         result = calc(operand1, operand2, sign);
    }
    //метод вывода данных в консоль
    private static void showResult() {
        System.out.println("Результат: " + result);
    }
    //инициализации переменных из метода initVars() при помощи scanner
    public static int getNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        return sc.nextInt();
    }
    //пользователю предложено выбрать математическую операцию
    //предусмотрен возврат, если пользователь введет цифру вне диапазона
    public static char getOperation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Выберите номер операции:
                1 - плюс
                2 - минус
                3 - умножить
                4 - разделить""");
        int operationNumber;
        if (sc.hasNextInt()) {
           operationNumber = sc.nextInt();
       } else {
           System.out.println("Пожалуйста, следуйте условию");
           return getOperation();
        }
        switch (operationNumber) {
            case 1:
                return '+';
            case 2:
                return '-';
            case 3:
                return '*';
            case 4:
                return '/';
            default:
                System.out.println("Введите цифру согласно условию");
               return getOperation();
        }
   }
   // методы математических расчетов согласно вводу клиента
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double sub(double num1, double num2) {
        return num1 - num2;
    }

    public static double mul(double num1, double num2) {
        return num1 * num2;
    }
   //предусмотрено введение пользователем при делении нуля
    public static double div(double num1, double num2) {
        if (num2 != 0.0) {
            return num1 / num2;
        } else {
            System.out.println("На 0 делить нельзя!");
            return 0;
        }
    }
    //подбор математического метода согласно вводу пользователя
    public static double calc(double num1, double num2, char operation) {
        return switch (operation) {
            case '+' -> add(num1, num2);
            case '-' -> sub(num1, num2);
            case '*' -> mul(num1, num2);
            case '/' -> div(num1, num2);
            default -> 0;
        };
    }
}


