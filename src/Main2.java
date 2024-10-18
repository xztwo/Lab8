import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String gender;
    private int salary;

    public Employee(String name, int age, String gender, int salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }
}

public class Main2 {
    public static void main(String[] args) {
        // Список сотрудников
        Employee[] persons = new Employee[]{
                new Employee("Semyon", 20, "Male", 300000),
                new Employee("Nikita", 20, "Male", 300000),
                new Employee("Egor", 21, "Male", 250000),
                new Employee("Alex", 19, "Male", 210000),
                new Employee("Mariya", 18, "Female", 33000),
                new Employee("Artem", 19, "Male", 19000),
                new Employee("YuliyaFr", 20, "Female", 18000),
                new Employee("Alena", 19, "Female", 15000),
                new Employee("Oleg", 54, "Male", 300000),
                new Employee("Nataliya", 50, "Female", 25000),
                new Employee("Yuliya", 29, "Female", 27000)
        };

        // Вызов метода для обработки сотрудников
        magicMethod(persons);
    }

    public static void magicMethod(Employee[] personal) {
        int numberEmployes = 3;  // Количество сотрудников, которых нужно отобрать

        // Обработка сотрудников и вывод результатов
        System.out.println(Arrays.stream(personal)
                .filter(e -> e.getGender().equals("Male"))  // Фильтр по полу (мужчины)
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())  // Сортировка по зарплате (по убыванию)
                .limit(numberEmployes)  // Ограничение до 3 сотрудников
                .sorted(Comparator.comparingInt(Employee::getAge))  // Сортировка по возрасту (по возрастанию)
                .map(Employee::getName)  // Получение имен сотрудников
                .collect(Collectors.joining(" и ", "У ", " самые высокие зарплаты"))); // Прямой вывод результата
    }
}
