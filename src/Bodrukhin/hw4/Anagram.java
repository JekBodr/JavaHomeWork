package hw4;
/*
 * Работа со строками: Регулярныее выражения, compare()
 *@Author Bodrukhin Yevhen
 * version 1.0.0
 */

import java.util.Arrays;
import java.util.Scanner;


public class Anagram {
    static String clientData1;
    static String clientData2;
    static char[] charArray1;
    static char[] charArray2;
    static String sortedString1;
    static String sortedString2;

    public static void main(String[] args) {
        //Приём строк от пользователя
        inputData();
        //Удаляет знаки препинания, переводит значения в нижний регистр
        deletePunctuation();
        //Сортирует String, при помощи массива
        sortData();
        //сравнивает отсорттированные данные, boolean, if else
        compareData();
    }

    private static void inputData() {
        System.out.println("Введите первую  фразу");
        Scanner input = new Scanner(System.in);
        clientData1 = input.nextLine();
        System.out.println("Введите вторую  фразу");
        clientData2 = input.nextLine();
    }

    private static void deletePunctuation() {
        clientData1 = clientData1.replaceAll("[^\\p{L}\\p{Nd}]+", "");
        clientData2 = clientData2.replaceAll("[^\\p{L}\\p{Nd}]+", "");
        clientData1= clientData1.toLowerCase();
        clientData2= clientData2.toLowerCase();
    }

    private static void sortData() {
        charArray1 = clientData1.toCharArray();
        Arrays.sort(charArray1);
        sortedString1 = new String(charArray1);

        charArray2 = clientData2.toCharArray();
        Arrays.sort(charArray2);
        sortedString2 = new String(charArray2);

    }

    private static void compareData() {
        boolean equals = sortedString1.equals(sortedString2);
        if(equals)
            System.out.println("\nФразы являются анаграммой");
        else {
            System.out.println("\nФразы не являются анаграммой");
        }
    }
}



