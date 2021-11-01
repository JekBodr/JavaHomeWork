package hw5;

public class Reader {

    String name = "Петров В. В";
    int number = 888;
    String department = "Юридический";
    String birthData = "01.01.2010";
    String phoneNumber = "+55574673";


    public void takeBook(String name) {
        System.out.println("--------------\n" + name + " взял 3 книги");
    }

    public void takeBook(String name, String bookName, String bookName1, String bookName2) {
        System.out.println("--------------\n" + name + " взял книги: " + bookName
                + ", " + bookName1 + ", " + bookName2);
    }

    public void takeBook(String name, String bookName, String authorName, String bookYear,
                         String bookName1, String authorName1, String bookYear1,
                         String bookName2, String authorName2, String bookYear2) {
        System.out.println("--------------\n" + name + " взял книги: " + bookName
                + " (" + authorName + bookYear + "), " + bookName1 + " (" + authorName1 + bookYear1 + "), "
                + bookName2 + " (" + authorName2 + bookYear2 + "), ");
    }

    public void returnBook(String name) {
        System.out.println("--------------\n" + name + " вернул 3 книги");
    }

    public void returnBook(String name, String bookName, String bookName1, String bookName2) {
        System.out.println("--------------\n" + name + " вернул книги: " + bookName
                + ", " + bookName1 + ", " + bookName2);
    }

    public void returnBook(String name, String bookName, String authorName, String bookYear,
                           String bookName1, String authorName1, String bookYear1,
                           String bookName2, String authorName2, String bookYear2) {
        System.out.println("--------------\n" + name + " вернул книги: " + bookName
                + " (" + authorName + bookYear + "), " + bookName1 + " (" + authorName1 + bookYear1 + "), "
                + bookName2 + " (" + authorName2 + bookYear2 + "), ");
    }
}






