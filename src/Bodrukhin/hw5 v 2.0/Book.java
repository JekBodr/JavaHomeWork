package hw5;

public class Book {

    private final String bookName;
    private final String bookAuthor;
    private final int bookYear;

    public Book(String bookName, String bookAuthor, int bookYear) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getBookYear() {
        return bookYear;
    }
}




