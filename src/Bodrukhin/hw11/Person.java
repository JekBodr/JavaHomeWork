package hw11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Person {
    private String name;
    private String address;
    private String[] phones;
    private transient LocalDate dateOfBirth;
    private transient LocalDateTime modified;

    public Person(String fullName, String address, String[] phones,
                  LocalDate dateOfBirth, LocalDateTime modified) {
        this.name = fullName;
        this.address = address;
        this.phones = phones;
        this.dateOfBirth = dateOfBirth;
        this.modified = modified;
    }
    public Person() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhones(String[] phones) {
        this.phones = phones;
    }
    public void setDateOfBirth(int y, int m, int d) {
        this.dateOfBirth = LocalDate.of(y, m, d);
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String[] getPhones() {
        return phones;
    }

    public String getDateOfBirth() {
        return dateOfBirth.toString();
    }

    public String getModified() {
        return modified.toString();
    }

    @Override
    public String toString() {
        return "\n{ФИО: " + name + "\n" +
               "Адрес: " + address + "\n" +
               "Дата рождения: " + dateOfBirth + "\n" +
               "Телефоны: " + Arrays.toString(phones) + "\n" +
               "Время изменения: " + modified + "}";
    }
}
