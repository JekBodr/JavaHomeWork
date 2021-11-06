package hw6;

import java.util.Objects;

public  class Animal {

       public String food;
       public String location;

       public Animal() {
       }

       public Animal(String food, String location) {
              this.food = food;
              this.location = location;
       }

       public String getFood() {
              return food;
       }

       public void setFood(String food) {
              this.food = food;
       }

       public String getLocation() {
              return location;
       }

       public void setLocation(String location) {
              this.location = location;
       }

       public  void eat(){
              System.out.println("Животное ест.");
       }

       public String makeNoise()
       {
              System.out.println("Животное произносит.");
              return null;
       }

       public void sleep() {
              System.out.println("Животное спит.");
       }

       @Override
       public boolean equals(Object o) {
              if (this == o) return true;
              if (o == null || getClass() != o.getClass()) return false;
              Animal animal = (Animal) o;
              return Objects.equals(food, animal.food) && Objects.equals(location, animal.location);
       }
       @Override
       public int hashCode() {
              return Objects.hash(food, location);
       }
}

