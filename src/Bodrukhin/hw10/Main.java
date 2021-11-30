package hw10;

public class Main {
    public static void main(String[] args) {

        NumBox<Integer> numBox = new NumBox<>(3);
        numBox.set(0, new Integer(10));
        numBox.set(1, new Integer(100));
        numBox.set(2, new Integer(120));
        System.out.println("------------------------" );
        show(numBox);
        System.out.println("------------------------" );
        NumBox<Float> numBox1 = new NumBox<>(3);
        numBox1.set(0, new Float(10));
        numBox1.set(1, new Float(1000));
        numBox1.set(2, new Float(20));
        System.out.println("------------------------" );
        show(numBox1);
        System.out.println("------------------------" );
    }
    public static void show(NumBox<?> numBox){

        System.out.println("Сумма всех элементов массива: "+numBox.sum());
        System.out.println("Текущее колличество элементов "+numBox.length());
        System.out.println("Среднее значение " +numBox.average());
        System.out.println("Максимумальный элемент массива "+ numBox.max());
        int index = (int) (Math.random()*numBox.length());
        System.out.println("Значение елемента "+(index+1)+" равно "+numBox.get(index));
    }
}

