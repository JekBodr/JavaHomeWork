package hw4;
/*
 * Работа со строками: пользователь вводит фразу
 * метод toUpperCase переводит первую букву слова в верхний регистр
 *@Author Bodrukhin Yevhen
 * version 1.0.0
 */

import java.util.Scanner;


public class CapitalLetter {
    static String clientData;
    static StringBuilder builder;



    public static void main(String[] args) {

        //Приём строки от пользователя
        inputData();
        //переводит первую букву слова в верхний регистр
        toUppFirstLetter();
        printData();

        }

    private static void inputData() {
        System.out.println("Введите фразу");
        Scanner input = new Scanner(System.in);
        clientData = input.nextLine();
    }

    private static void toUppFirstLetter() {
        builder = new StringBuilder(clientData);

        if (Character.isAlphabetic(clientData.codePointAt(0)))
            builder.setCharAt(0, Character.toUpperCase(clientData.charAt(0)));

        for (int i = 1; i < clientData.length(); i++)
            if (Character.isAlphabetic(clientData.charAt(i)) && Character.isSpaceChar(clientData.charAt(i - 1)))
                builder.setCharAt(i, Character.toUpperCase(clientData.charAt(i)));
    }

    private static void printData() {
        System.out.println(builder);
    }
}
