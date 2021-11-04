package hw5;

public class Book {
    private String bookName;
    private String bookAuthor;
    private int bookYear;

    public Book(String bookName, String bookAuthor,int bookYear) {
            this.bookName = bookName;
            this.bookAuthor = bookAuthor;
            this.bookYear = bookYear;
    }
    public Book() {
        }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
            this.bookName = bookName;
        }

    public String getBookAuthor() {
        return bookAuthor;
    }


    public void setBookAuthor(String bookAuthor) {
            this.bookAuthor = bookAuthor;
        }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    public String getInfo() {
        return  bookName + ", " + bookAuthor +  ", " + bookYear ;
    }

    }

