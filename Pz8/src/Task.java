package Pz8;

import java.util.*;

class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getLastName() {
        return lastName;
    }

    // Потрібно для Set і Map
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        return firstName.equals(e.firstName) &&
                lastName.equals(e.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (ЗП: " + salary + ")";
    }
}


class Department {
    private String name;
    private Employee head;
    private Set<Employee> employees; // HashSet замість List

    public Department(String name, Employee head) {
        this.name = name;
        this.head = head;
        this.employees = new HashSet<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String getName() {
        return name;
    }

    public Employee getHead() {
        return head;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }
}


class Firm {
    private String name;
    private Employee director;
    private Set<Department> departments; // HashSet

    public Firm(String name, Employee director) {
        this.name = name;
        this.director = director;
        this.departments = new HashSet<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public Employee getDirector() {
        return director;
    }

    public Set<Department> getDepartments() {
        return departments;
    }
}


public class Task {

    public static void main(String[] args) {

        Employee director = new Employee("Максим", "Андріяшин", 50000);
        Firm firm = new Firm("TechSolutions", director);

        Employee headIT = new Employee("Іван", "Мельник", 40000);
        Department itDept = new Department("IT відділ", headIT);
        itDept.addEmployee(new Employee("Оксана", "Ковальчук", 25000));
        itDept.addEmployee(new Employee("Владислав", "Довгополий", 28000));
        itDept.addEmployee(new Employee("Олексій", "Ткаченко", 42000));

        Employee headMarketing = new Employee("Анастасія", "Щур", 35000);
        Department marketingDept = new Department("Маркетинг", headMarketing);
        marketingDept.addEmployee(new Employee("Антон", "Білан", 20000));
        marketingDept.addEmployee(new Employee("Марія", "Шевченко", 18000));

        firm.addDepartment(itDept);
        firm.addDepartment(marketingDept);

        System.out.println("Фірма створена. Директор: " + firm.getDirector());

        // --- Завдання 1: Нетипізований ітератор ---
        System.out.println("\nЗавдання 1: нетипізований ітератор");

        double maxSalary = director.getSalary();
        Iterator deptIterator = firm.getDepartments().iterator();

        while (deptIterator.hasNext()) {
            Department d = (Department) deptIterator.next();

            if (d.getHead().getSalary() > maxSalary)
                maxSalary = d.getHead().getSalary();

            Iterator empIt = d.getEmployees().iterator();
            while (empIt.hasNext()) {
                Employee emp = (Employee) empIt.next();
                if (emp.getSalary() > maxSalary)
                    maxSalary = emp.getSalary();
            }
        }
        System.out.println("Найбільша зарплата у фірмі: " + maxSalary);


        // --- Завдання 2: типізований ітератор ---
        System.out.println("\nЗавдання 2: типізований ітератор");

        for (Department dept : firm.getDepartments()) {
            double headSalary = dept.getHead().getSalary();
            boolean found = false;

            for (Employee emp : dept.getEmployees()) {
                if (emp.getSalary() > headSalary) {
                    System.out.println(emp +
                            " отримує більше за начальника " + dept.getName());
                    found = true;
                }
            }
            if (!found)
                System.out.println("У відділі " + dept.getName() +
                        " немає працівників з більшою ЗП");
        }


        // --- Завдання 3: for-each ---
        System.out.println("\nЗавдання 3: цикл for-each");

        Set<Employee> allStaff = new HashSet<>();
        allStaff.add(firm.getDirector());

        for (Department dept : firm.getDepartments()) {
            allStaff.add(dept.getHead());
            allStaff.addAll(dept.getEmployees());
        }

        System.out.println("Усі співробітники (" + allStaff.size() + "):");
        for (Employee e : allStaff) {
            System.out.println("- " + e);
        }


        // --- Додаткова функціональність з HashMap ---
        System.out.println("\nДодаткова функціональність (HashMap):");

        // КАРТА: Назва відділу → кількість працівників
        Map<String, Integer> deptSizeMap = new HashMap<>();

        for (Department dept : firm.getDepartments()) {
            deptSizeMap.put(dept.getName(), dept.getEmployees().size());
        }

        System.out.println("Кількість працівників у відділах: " + deptSizeMap);
    }
}
