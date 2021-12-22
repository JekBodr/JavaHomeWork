package hw12;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.util.*;
import java.time.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.*;

public class PhoneBook {
    private List<Person> phoneBook = new ArrayList<>();

    public void Add() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите ФИО: ");
            String name = scan.nextLine();
            System.out.println("Введите адрес: ");
            String address = scan.nextLine();
            System.out.println("Сколько у пользователя номеров?");
            int size = scan.nextInt();
            scan.nextLine();
            if (size <= 0)
                throw new IllegalArgumentException();
            String[] phones = new String[size];
            for (int i = 0; i < size; i++) {
                System.out.println("Введите номер:");
                phones[i] = scan.nextLine();
            }
            System.out.println("Поочередно введите день, месяц и год рождения: ");
            int day = scan.nextInt();
            int month = scan.nextInt();
            int year = scan.nextInt();
            phoneBook.add(new Person(name, address, phones, LocalDate.of(year, month, day), LocalDateTime.now()));
        } catch (Exception e) {
            System.err.println("Ошибка создания пользователя.");
        }
    }

    public String showPhoneBook() {
        return phoneBook.toString();
    }

    public void Remove() {
        Scanner scan = new Scanner(System.in);
        try {

            System.out.println("Введите ФИО для удаления контакта: ");
            String str = scan.nextLine();
            phoneBook.removeIf(p -> p.getName().contains(str));
            System.out.println("Контакт успешно удалён.");
        } catch (Exception e) {
            System.err.println("Ошибка удаления пользователя.");
        }
    }
    public boolean Search() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите любое значение для поиска: ");
        String str = scan.nextLine();
        Pattern pat = Pattern.compile(str);
        phoneBook.forEach((p) -> {
            Matcher mat = pat.matcher(p.toString());
            if (mat.find())
                System.out.println(p);
            else
                System.out.println("Пользователь не найден");
        });
        return false;
    }

    public void Modify() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите ФИО пользователя для редактирования: ");
            String str = scan.nextLine();
            for (Person p : phoneBook) {
                if (p.getName().contains(str)) {
                    System.out.println("Пользователь найден.");
                    System.out.println(p);
                    System.out.println("Для изменения ФИО введите 'name'");
                    System.out.println("Для изменения адреса введите 'address'");
                    System.out.println("Для изменения даты рождения введите 'date'");
                    System.out.println("Для изменения номера введите 'phone'");
                    String choice = scan.nextLine();
                    LocalDateTime changes = LocalDateTime.now();
                    switch (choice) {
                        case "name":
                            System.out.println("Введите новое ФИО: ");
                           String newName = scan.nextLine();
                            p.getName(newName);
                            p.setModified(changes);
                            System.out.println("ФИО успешно изменено!");
                            break;
                        case "address":
                            System.out.println("Введите новый адрес: ");
                            String newAddress = scan.nextLine();
                            p.setAddress(newAddress);
                            p.setModified(changes);
                            System.out.println("Адрес успешно изменен!");
                            break;
                        case "phone":
                            System.out.println("Сколько номеров у пользователя?");
                            int size = scan.nextInt();
                            for (int n = 0; n < size; n++) {
                                System.out.println("Введите номер: ");
                                scan.nextLine();
                                System.out.println("Номер успешно изменён");
                            }
                            break;
                        case "date":
                            System.out.println("Введите поочередно день, месяц и год рождения: ");
                            int dd = scan.nextInt();
                            int mm = scan.nextInt();
                            int yy = scan.nextInt();
                            p.setDateOfBirth(yy, mm, dd);
                            p.setModified(changes);
                            System.out.println("Дата рождения успешно изменена!");
                            break;
                        default:
                            System.out.println("Неверный запрос.");
                            break;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка редактирования пользователя.");
        }
    }

    public String SortByDateOfBirth() {
        Comparator<Person> cmp = (p1, p2) -> p1.getDateOfBirth().compareTo(p2.getDateOfBirth());
        phoneBook.sort(cmp);
        return phoneBook.toString();
    }
    public String SortByName() {
        Comparator<Person> cmp = Comparator.comparing(Person::getModified);
        phoneBook.sort(cmp);
        return phoneBook.toString();
    }
    public void toFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            SimpleModule module = new SimpleModule();
            module.addSerializer(LocalDate.class, new LocalDateSerializer());
            module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
            module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
            module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
            mapper.registerModule(module);
            Path file = Files.createFile(Paths.get("phonebook.json"));
            String json = mapper.writeValueAsString(phoneBook);
            try (BufferedWriter wr = Files.newBufferedWriter(file)) {
                wr.write(json);
                System.out.println("Данные успешно экспортированы!");
            }
        } catch (Exception e) {
            System.err.println("Ошибка записи в файл.");
        }
    }
    public void fromFile() {
        try {
            File file = Paths.get("phonebook.json").toFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            SimpleModule module = new SimpleModule();
            module.addSerializer(LocalDate.class, new LocalDateSerializer());
            module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
            module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
            module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
            mapper.registerModule(module);
            List<Person> persons = mapper.readValue(file, new TypeReference<List<Person>>() {});
            phoneBook.addAll(persons);
            System.out.println("Данные успешно импортированы!");
        } catch (Exception e) {
            System.err.println("Ошибка записи файла.");
        }
    }
}
