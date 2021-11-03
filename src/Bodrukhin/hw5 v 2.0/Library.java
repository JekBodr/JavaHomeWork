package hw5;

/*
 *
 *@Author Bodrukhin Yevhen
 * version 1.1.0
 */



public class Library {
    static Book[] allBooks = new Book[3];
    static Reader[] readers = new Reader[1];

    public static void main(String[] args) {

       showBooks();
       showReaders();
       showTakeGetBook();

    }
    private static void showBooks() {
        allBooks[0] = new Book("Приключения", "Иванов И. И.", 2000);
        allBooks[1] = new Book("Словарь", "Сидоров А. В.", 1980);
        allBooks[2] = new Book("Энциклопедия", "Гусев К. В", 2010);

        System.out.println("Книги нашей библиотеки:");
        for (Book allBook : allBooks) {
            System.out.println(allBook.getBookName() + " " + allBook.getBookAuthor() + " " + allBook.getBookYear());
        }
    }

    private static void showReaders() {
        readers[0] = new Reader( "Петров В. В", 888, "Юридический",
                "01.01.2005","+55574673" );
        System.out.println("\nЧитатели нашей библиотеки:");
        for (Reader reader : readers) {
            System.out.println(reader.getName() + " " + reader.getNumber() +
                    " " + reader.getDepartment() + " " + reader.getBirthData() + " "
                    + reader.getPhoneNumber());
        }
    }

    private static void showTakeGetBook() {
        int count = allBooks.length;
        Reader getInfo = new Reader();

        getInfo.takeBook(readers[0].getName(),count);

        getInfo.takeBook(readers[0].getName(),allBooks[0].getBookName(),allBooks[1].getBookName(),
                allBooks[2].getBookName());

        getInfo.takeBook(readers[0].getName(),allBooks[0].getBookName(),allBooks[0].getBookAuthor(),
                allBooks[0].getBookYear(),allBooks[1].getBookName(),allBooks[1].getBookAuthor(),
                allBooks[1].getBookYear(),allBooks[2].getBookName(),allBooks[2].getBookAuthor(),
                allBooks[2].getBookYear());

        getInfo.returnBook(readers[0].getName(),count);

        getInfo.returnBook(readers[0].getName(),allBooks[0].getBookName(),allBooks[1].getBookName(),
                allBooks[2].getBookName());

        getInfo.returnBook(readers[0].getName(),allBooks[0].getBookName(),allBooks[0].getBookAuthor(),
                allBooks[0].getBookYear(),allBooks[1].getBookName(),allBooks[1].getBookAuthor(),
                allBooks[1].getBookYear(),allBooks[2].getBookName(),allBooks[2].getBookAuthor(),
                allBooks[2].getBookYear());
    }

}
