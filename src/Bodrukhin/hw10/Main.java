package hw10;

public class Main {
    public static void main(String[] args) {


        NumBox<DeepNumbers> deepNumbersNumBox = new NumBox<>(100);
        deepNumbersNumBox.set(0, new DeepNumbers(1));
        deepNumbersNumBox.set(1, new DeepNumbers(2));
        DeepNumbers numbers = deepNumbersNumBox.get(0);
        DeepNumbers numbers2 = deepNumbersNumBox.get(1);
        System.out.println(numbers.getNumber());
        System.out.println(numbers2.getNumber());
    }
}

