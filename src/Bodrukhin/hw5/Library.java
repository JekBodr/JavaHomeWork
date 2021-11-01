package hw5;

/*
 * Работа со строками: Регулярныее выражения, compare()
 *@Author Bodrukhin Yevhen
 * version 1.0.0
 */


import java.util.Arrays;

public class Library {
  static Reader reader = new Reader();
  static Book book = new Book();
  static String[] readerInfo;
  static String[] bookInfo;
  static String[] bookInfo1;
  static String[] bookInfo2;


    public static void main(String[] args) {
        initData();
        showData();
        takeABook();
        returnABook();


    }



    private static void initData() {
         readerInfo = new String[] {reader.name, String.valueOf(reader.number), reader.department,
                 reader.birthData, reader.phoneNumber};
         bookInfo = new String[]{book.bookName, book.bookAuthor, String.valueOf(book.bookYear)};
         bookInfo1 = new String[]{ book.bookName1, book.bookAuthor1, String.valueOf(book.bookYear1)};
         bookInfo2 = new String[]{ book.bookName2, book.bookAuthor2, String.valueOf(book.bookYear2)};
    }

    private static void showData() {
        System.out.println("--------------" + "\nВсе книги нашей библиотеки \n1. " +Arrays.toString(bookInfo)+
                "\n2. " + Arrays.toString(bookInfo1) +  "\n3. " + Arrays.toString(bookInfo2) );
        System.out.println("--------------" + "\nНаши читатели (ФИО, номер читательского билета, факультет, " +
                "дата рождения, телефон" + " \n1. " +Arrays.toString(readerInfo));

    }

    private static void takeABook() {
        reader.takeBook(reader.name);
        reader.takeBook(reader.name, bookInfo[0],bookInfo1[0],bookInfo2[0] );
        reader.takeBook(reader.name, bookInfo[0],bookInfo[1],bookInfo[2], bookInfo1[0],bookInfo1[1],bookInfo1[2],
                bookInfo2[0],bookInfo2[1],bookInfo2[2]);
    }

    private static void returnABook() {
        reader.returnBook(reader.name);
        reader.returnBook(reader.name, bookInfo[0],bookInfo1[0],bookInfo2[0]);
        reader.returnBook(reader.name, bookInfo[0],bookInfo[1],bookInfo[2], bookInfo1[0],bookInfo1[1],bookInfo1[2],
                bookInfo2[0],bookInfo2[1],bookInfo2[2]);


    }

}
