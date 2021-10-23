package hw3;

import java.util.Scanner;

public class Array {
    static int[] array;
    static int arraySum;

    public static void main(String[] args) {

        // Пользователь заполняет содержимое массива
        inputData();
        // Вывод массива на экран
        printData();
        //Считает сумму введен чисел, выводит на экран
        printSumData();
        //Считает колличество положительнх элементов, выводит на экран
        printPositiveData();
        //Сортирует от большего к меньшему и выводит на экран
        printSortData();
    }

    private static void inputData() {
        Scanner input = new Scanner(System.in); // Объявляем Scanner
        array = new int[10];
        System.out.println("Введите 10  чисел:");
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
    }

    private static void printData() {
        System.out.print("Вы ввели 10 цифр: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }

    private static void printSumData() {
        arraySum = getSum(array);
        System.out.println("\nСумма введенных чисел = " + arraySum);
    }

    private static int getSum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    private static void printPositiveData() {
        int counter = 0;
        for(int i = 0; i<array.length; i++)
        {
            if(array[i] > 0)
                counter += 1;
        }
        System.out.println("Колличество введенных положительных цифр: " + counter);
    }

    private static void printSortData() {
        bubbleSort(array);
        System.out.print("Числа от меньшего к большему: ");
        for (int number : array) System.out.print(number + " ");
    }

    private static void bubbleSort(int[] array) {
        int n = array.length;
        int temp;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {

                    temp = Array.array[j - 1];
                    array[j - 1] = Array.array[j];
                    array[j] = temp;
                }
            }
        }
    }

}