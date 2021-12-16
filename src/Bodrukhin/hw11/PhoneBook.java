package hw11;

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

public class PhoneBook {
    private List<Person> phoneBook = new ArrayList<>();
    // добавление пользователя
    public void Add() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите ФИО: ");
            String name = scanner.nextLine();
            System.out.println("Введите адрес: ");
            String address = scanner.nextLine();
            System.out.println("Колличество телефонных номеров?");
            int size = scanner.nextInt();
            scanner.nextLine();
            if (size <= 0)
                throw new IllegalArgumentException();
            String[] phones = new String[size];
            for (int i = 0; i < size; i++) {
                System.out.println("Введите номер:");
                phones[i] = scanner.nextLine();
            }
            System.out.println("Введите дату рождения ");
            int day = scanner.nextInt();
            int month = scanner.nextInt();
            int year = scanner.nextInt();
            phoneBook.add(new Person(name, address, phones, LocalDate.of(year, month, day), LocalDateTime.now()));
        } catch (Exception e) {
            System.err.println("Ошибка");
        }
    }
    public String showPhoneBook() {
        return phoneBook.toString();
    }
    // удаление пользователя
    public void Remove() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Введите ФИО для удаления контакта: ");
            String str = scan.nextLine();
            String[] ph = new String[1];
            Person def = new Person(str, "default", ph,
                    LocalDate.of(1970, 1, 1), LocalDateTime.now());
            for (int i = 0; i < phoneBook.size(); i++) {
                if (phoneBook.get(i).getName().equals(def.getName()))
                    phoneBook.remove(i);
                System.out.println("Пользователь удален!");
            }
        } catch (Exception e) {
            System.err.println("Ошибка.");
        }
    }
    // поиск пользователя
    public String Search() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ФИО для поиска: ");
        String str = scan.nextLine();
        String[] p = new String[0];
        Person def = new Person(str, "default", p,
                LocalDate.of(1970, 1, 1), LocalDateTime.now());
        for (Person person : phoneBook) {
            if (person.getName().equals(def.getName()))
                return person.toString();
        }
        return "Пользователь не найден.";
    }
    // редактирование пользователя
    public void Modify() {
        try {
            // алгоритм аналогичен Search()
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите ФИО пользователя для редактирования: ");
            String[] p = new String[0];
            String str = scan.nextLine();
            Person def = new Person(str, "default", p,
                    LocalDate.of(1970, 1, 1), LocalDateTime.now());
            for (Person person : phoneBook) {
                if (person.getName().equals(def.getName())) {
                    System.out.println("Пользователь найден.");
                    System.out.println(person);
                    System.out.println("Для изменения ФИО введите 'name'");
                    System.out.println("Для изменения адреса введите 'address'");
                    System.out.println("Для изменения даты рождения введите 'date'");
                    System.out.println("Для изменения номера введите 'phone'");
                    String choice = scan.nextLine();
                    LocalDateTime changes = LocalDateTime.now();
                    switch (choice) {
                        case "name" -> {
                            System.out.println("Введите новое ФИО: ");
                            String newName = scan.nextLine();
                            person.setName(newName);
                            person.setModified(changes);
                            System.out.println("ФИО  изменено!");
                        }
                        case "address" -> {
                            System.out.println("Введите новый адрес: ");
                            String newAddress = scan.nextLine();
                            person.setAddress(newAddress);
                            person.setModified(changes);
                            System.out.println("Адрес успешно изменен!");
                        }
                        case "phone" -> {
                            System.out.println("Сколько номеров у пользователя?");
                            int size = scan.nextInt();
                            for (int n = 0; n < size; n++) {
                                System.out.println("Введите номер: ");
                                scan.nextLine();
                                System.out.println("Номер успешно изменён");
                            }
                        }
                        case "date" -> {
                            System.out.println("Введите дату рождения: ");
                            int dd = scan.nextInt();
                            int mm = scan.nextInt();
                            int yy = scan.nextInt();
                            person.setDateOfBirth(yy, mm, dd);
                            person.setModified(changes);
                            System.out.println("Дата рождения успешно изменена!");
                        }
                        default -> System.out.println("Неверный запрос.");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка редактирования пользователя.");
        }
    }
    public String SortByDateOfBirth() {
        Comparator<Person> sortingA =Comparator.comparing(Person::getDateOfBirth);
        phoneBook.sort(sortingA);
        return phoneBook.toString();
    }
    public String SortByName() {
        Comparator<Person> sortingB = Comparator.comparing(Person::getModified);
        phoneBook.sort(sortingB);
        return phoneBook.toString();
    }
    // запись данных в файл
    public void toFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            SimpleModule module = new SimpleModule();
            module.addSerializer(LocalDate.class, new LocalDateSerializer());
            module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
            module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
            module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
            mapper.registerModule(module);
            Path file = Files.createFile(Paths.get("phBook.json"));
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
            File file = Paths.get("phBook.json").toFile();
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
