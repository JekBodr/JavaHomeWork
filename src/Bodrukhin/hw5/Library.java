package hw5;

public class Library {
    public static void main(String[] args) {

        Book book1 = new Book("Приключения", "Иванов И. И.",1980);
        Book book2 = new Book("Словарь", "Сидоров А.В.",1980);
        Book book3 = new Book("Энциклопедия", "Гусев К. В.",2000);
        Book[] books = {book1, book2, book3};

        Reader reader1 = new Reader("Петров В.В.", 888,
                "Исторический", "01.01.1999", "+55555555");
        Reader[] readers = {reader1};


        printBooks(books);
        printReaders(readers);

        reader1.takeBook(books.length);

        reader1.takeBook(" Приключения ", "Словарь ","Энциклопедия ");

        reader1.takeBook(" Приключения (Иванов И. И. 2000 г.),","Словарь (Сидоров А. В 1980 г.)"
                + "Энциклопедия (Гусев К. В. 2010 г.)");


        reader1.returnBook(books.length);
       reader1.returnBook(" Приключения ", "Словарь ","Энциклопедия ");
        reader1.returnBook(" Приключения (Иванов И. И. 2000 г.),","Словарь (Сидоров А. В 1980 г.)"
                + " Энциклопедия (Гусев К. В. 2010 г.)");

    }

    private static void printBooks(Book[] books) {
        System.out.println("Все книги нашей библиотеки:");
        for (Book book : books) {
            System.out.println(book.getInfo());
        }
        System.out.println();
    }

    private static void printReaders(Reader[] readers) {
        System.out.println("Наши читатели (ФИО, номер читательского билета, факультет, номер телефона)");
        for (Reader reader : readers) {
            System.out.println( reader.getInfo());
        }
        System.out.println();
    }
}
