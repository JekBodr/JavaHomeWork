package hw6;

import java.util.Objects;

public class Cat extends Animal {
    private String mustache;

    public Cat() {
    }

    public Cat(String food, String location,String mustache) {
        super(food, location);
        this.mustache = mustache;
    }

    public String getMustache() {
        return mustache;
    }

    public void setMustache(String mustache) {
        this.mustache = mustache;
    }

    @Override
    public void eat() {
        System.out.println("Кошка ест.");
    }

    @Override
    public String makeNoise() {
        return "Мяу!";
    }

    @Override
    public void sleep() {
        System.out.println("Кошка спит.");
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mustache);
    }

    @Override
    public String toString() {
        return "Кошка " + "ест " + getFood() + ", живёт в " + getLocation() +
                ", лечим: "  + getMustache();
    }
}