package hw10;

public class NumBox<T extends Number> {

    private final T[] numbers;


    @SuppressWarnings("unchecked")
    public NumBox(int size) {
        numbers = (T[]) new Number[size];
    }
    public void set(int index, T number ) {
        this.numbers[index] = (T) number;
    }

    public void add(int index, T num) throws ArrayIndexOutOfBoundsException {
        try {
            if (index > numbers.length) {
                throw new ArrayIndexOutOfBoundsException();
            } else numbers[index] = num;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Массив переполнен! Длина массива  " + numbers.length);
            e.printStackTrace();
        }
    }

    public T get(int index) {
        return numbers[index];
    }
    public int length() {
        int count = 0;
        for(T i : numbers){
            if(!(i == null)){
                count++;
            } else count+=0;
        }
        return count;
    }

    public double average() {
        return (sum()/length());
    }
    public double sum() {
        int sum = 0;
        for(T i : numbers){
            sum = (int) (sum + i.doubleValue());
        }
        return sum;
    }

   public T max() {
       T maX = numbers[0];
       for(int i = 0; i < numbers.length; i++){
           if(numbers[i].intValue() > maX.intValue()) {
               maX = numbers[i];
           }
       }
       return maX;
   }
}




