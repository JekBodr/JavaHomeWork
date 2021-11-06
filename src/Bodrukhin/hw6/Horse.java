package hw6;


import java.util.Objects;

public class Horse extends Animal {
    private String mane;

    public Horse() {
    }
    public Horse(String food, String location, String mane) {
        super(food, location);
        this.mane = mane;
    }

    public String getMane() {
        return mane;
    }

    public void setMane(String mane) {
        this.mane = mane;
    }

    @Override
    public void eat() {
        System.out.println("Лошадь ест.");
    }

    @Override
    public String makeNoise() {
        return "Пррррр!";
    }
    @Override
    public void sleep() {
        System.out.println("Лошадь  спит стоя.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Horse horse = (Horse) o;
        return Objects.equals(mane, horse.mane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mane);
    }

    @Override
    public String toString() {
          return "Лошадь " + "ест " + getFood() + ", живёт в " + getLocation() + " , лечим: " + getMane();
    }
}
