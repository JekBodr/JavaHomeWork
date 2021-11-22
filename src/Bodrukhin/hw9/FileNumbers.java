package hw9;

import java.io.*;
import java.util.*;



public class FileNumbers {
    static int[][] numbers;



    public static void main(String[] args) throws IOException {
        createNumbersFile();
        createOddNumbersFile();
    }

    private static void createNumbersFile() throws FileNotFoundException {
        System.out.println("---------------------\n" +
                "Создание срок  случайных чисел от 1 до 99" +
                " в файле numbers.txt");
        File file = new File("d:\\Users\\dn010391beo\\IdeaProjects\\Bodrukhin\\src\\hw9/numbers.txt");
        PrintWriter pw = new PrintWriter(file);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                pw.print(((int) (Math.random() * 99)) + " ");
            }
            pw.print("\n");
        }
        pw.close();
        Scanner scanner = new Scanner(file);
        System.out.println("---------------------\n" +
                "Проверим, что в файле numbers.txt");

        while (scanner.hasNextInt()) {
            System.out.println(scanner.nextLine());
        }


    }

    private static void createOddNumbersFile() throws IOException {
        System.out.println("---------------------\n" +
                "Создадим файл " +
                " odd-numbers.txt");
        numbers = new int[10][10];
        Scanner scanner = new Scanner(new File("d:\\Users\\dn010391beo\\" +
                "IdeaProjects\\Bodrukhin\\src\\hw9/numbers.txt"));
        while (scanner.hasNext()) {
            for (int row = 0; row < numbers.length; row++) {
                for (int j = 0; j < numbers[row].length; j++) {
                    numbers[row][j] = Integer.parseInt(scanner.next());
                }
            }
        }

        File fileA = new File("d:\\Users\\dn010391beo\\IdeaProjects\\Bodrukhin\\src\\hw9/odd-numbers.txt");
        PrintWriter pw = new PrintWriter(fileA);
        for (int row = 0; row < numbers.length; row++) {
            for (int j = 0; j < numbers[row].length; j++) {
                if (numbers[row][j] % 2 == 0) {
                    numbers[row][j] = 0;
                }
                pw.print(numbers[row][j] + " ");
            }
            pw.println(" ");
        }
        pw.close();
        Scanner scannerA = new Scanner(fileA);
        System.out.println("---------------------\n" +
                "Проверим, что в файле odd-numbers.txt");
        while (scannerA.hasNextInt()) {
            System.out.println(scannerA.nextLine());
        }
    }
}












