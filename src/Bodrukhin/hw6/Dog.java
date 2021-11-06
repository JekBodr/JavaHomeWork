package hw6;

import java.util.Objects;

public class Dog extends Animal{
    private String ears;

    public Dog() {
    }

    public Dog(String food, String location, String ears) {
        super(food, location);
        this.ears = ears;
    }

    public String getEars() {
        return ears;
    }

    public void setEars(String ears) {
        this.ears = ears;
    }

    @Override
    public void eat() {
        System.out.println("Собака ест.");
    }

    @Override
    public String makeNoise() {
        return "Гав!";
    }

    @Override
    public void sleep() {
        System.out.println("Собака спит.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(ears, dog.ears);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ears);
    }

    @Override
    public String toString() {
        return "Собака " + "ест " + getFood() + ", живёт в " + getLocation()+
                ", лечим: "  + getEars();
    }
}
