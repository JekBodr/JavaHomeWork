package hw10;

public class NumBox<T extends Number> {

    private final T[] numbers;

    @SuppressWarnings("unchecked")
    public NumBox(int size) {
        numbers = (T[]) new Number[size];
    }


    public T get(int index) {
        return numbers[index];
    }

    public void set(int index, T vehicle) {
        this.numbers[index] = vehicle;
    }
}
