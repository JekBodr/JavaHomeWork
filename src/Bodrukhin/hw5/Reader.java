package hw5;

public class Reader
{
    private String name;
    private int number;
    private String faculty;
    private String birthData;
    private String phone;



    public Reader(String name, int number, String faculty, String birthData, String phone) {
        this.name = name;
        this.number = number;
        this.faculty = faculty;
        this.birthData = phone;
        this.phone = phone;
    }

    public Reader() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getBirthData() {
        return birthData;
    }

    public void setBirthData(String birthData) {
        this.birthData = birthData;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void takeBook(int number) {
        System.out.println(this.name + " взял " + number + " книги.");
    }

    public void takeBook(String... books) {
        System.out.print("----------------\n"+this.name + " взял книги: ");
        for (String book : books) {
            System.out.print(book);
        }
       System.out.println();
    }

    public void returnBook(int number) {
        System.out.println("----------------\n"+this.name + " вернул " + number + " книги.");
    }

    public void returnBook(String... books) {
        System.out.print("----------------\n"+this.name + " вернул книги:");
        for (String book : books) {
            System.out.print(book);
        }
        System.out.println();
    }



    public String getInfo() {
        return  name +  ", " + number + ", " + faculty + " " + birthData ;
    }
}
