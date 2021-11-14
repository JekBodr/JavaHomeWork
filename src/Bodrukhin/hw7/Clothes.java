package hw7;

public abstract  class Clothes {

    private Size size;
    private String color;
    private double cost;

    public Clothes(Size size, String color) {
        this.size = size;
        this.color = color;
    }

    public Clothes(Size size, String color, double cost) {
        this(size, color);
        this.cost = cost;
    }

    public Size getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
