package hw5;

public class Reader {



   private String name;
   private int  number;
   private  String department;
   private String birthData;
   private String phoneNumber;

   public Reader(){
   }

   public Reader(String name, int number, String department, String birthData, String phoneNumber) {
      this.name = name;
      this.number = number;
      this.department = department;
      this.birthData = birthData;
      this.phoneNumber = phoneNumber;
   }

   public String getName() {
      return name;
   }


   public int getNumber() {
      return number;
   }


   public String getDepartment() {
      return department;
   }

   public String getBirthData() {
      return birthData;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void takeBook(String name, int count) {
      System.out.println("--------------\n" +name + " взял "+ count +" книги");
   }

   public void takeBook(String name, String book, String book1, String book2) {
      System.out.println("--------------\n" + name + " взял книги " + book + ", " + book1 + ",  " + book2 +  "." );
   }
   public void takeBook(String name, String bookName, String authorName, int bookYear,
                        String bookName1, String authorName1, int bookYear1,
                        String bookName2, String authorName2, int bookYear2) {
      System.out.println("--------------\n" + name + " взял книги: " + bookName
              + " (" + authorName + bookYear + "), " + bookName1 + " (" + authorName1 + bookYear1 + "), "
              + bookName2 + " (" + authorName2 + bookYear2 + "), ");
   }
   public void returnBook(String name, int count) {
      System.out.println("--------------\n" +name + " вернул "+ count +" книги");
   }
   public void returnBook(String name, String book, String book1, String book2) {
      System.out.println("--------------\n" +name + " вернул книги " + book + ", " + book1 + ",  " + book2 +  "." );
   }
   public void returnBook(String name, String bookName, String authorName, int bookYear,
                          String bookName1, String authorName1, int bookYear1,
                          String bookName2, String authorName2, int bookYear2)
   {
      System.out.println("--------------\n" + name + " вернул книги: " + bookName
              + " (" + authorName + bookYear + "), " + bookName1 + " (" + authorName1 + bookYear1 + "), "
              + bookName2 + " (" + authorName2 + bookYear2 + "), ");
   }
}






