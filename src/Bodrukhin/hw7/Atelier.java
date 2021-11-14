package hw7;
/*
 * Наследование + aбстрактный класс+ наследование
 *@Author Bodrukhin Yevhen
 * version 1.0.0
 */
public class Atelier {

    public static void main(String[] args) {

        Clothes[] clothes = {
                new TShirt(Size.XXS, "Чёрный", 49.99),
                new Pants(Size.XS, "Белый", 69.99),
                new Skirt(Size.S, "Жёлтый", 59.99),
                new Tie(Size.M, "Зелёный", 29.99),
                new Tie(Size.L, "Красный", 29.99),
        };

        dressWomen(clothes);
        dressMan(clothes);
    }

    public static void dressMan(Clothes[] clothes) {
        System.out.println("-------------"+"\nМужская одежда:");
        for (Clothes i : clothes) {
            if (i instanceof ManClothes) {
                System.out.println(i);
            }
        }
    }

    public static void dressWomen(Clothes[] clothes) {
        System.out.println("-------------"+"\nЖенская одежда:");
        for (Clothes i : clothes) {
            if (i instanceof WomenClothes) {
                System.out.println(i);
            }
        }
    }
}
