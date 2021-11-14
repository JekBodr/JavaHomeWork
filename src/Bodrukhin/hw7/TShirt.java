package hw7;

public class TShirt extends Clothes implements ManClothes, WomenClothes {
    public TShirt(Size size, String color) {
        super(size, color);
    }

    public TShirt(Size size, String color, double cost) {
        super(size, color, cost);
    }

    @Override
    public String toString() {
        return "Футболка:" + " размер = " + getSize() + ", цена = " + getCost() + " грн" +
                ", цвет = " + getColor() + ".";
    }
}