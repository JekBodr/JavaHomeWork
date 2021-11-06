package hw6;
/*
 * Наследование + рефлексия
 *@Author Bodrukhin Yevhen
 * version 1.0.0
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class VetClinic {

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {

            Class vetClazz = Class.forName("hw6.Veterinarian");
            Constructor constructor= vetClazz.getConstructor();
            Object obj = constructor.newInstance();
            Animal animal1 = new Dog("Собачий корм", "Конура","Уши");
            Animal animal2 = new Cat("Кошачий корм", "Дом","Усы");
            Animal animal3 = new Horse("Сено", "Стойло","Гриву");
            Animal [] animals = {animal1,animal2,animal3};
            for (Animal animal : animals) {
            ((Veterinarian) obj).treatAnimal(animal);
        }
    }
}

