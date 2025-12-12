package lab7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @Override
    public String toString() {
        return firstName + " " + lastName + " (ЗП: " + salary + ")";
    }
}

class Department {
    private String name;
    private Employee head; // Начальник відділу
    private List<Employee> employees; // Список працівників

    public Department(String name, Employee head) {
        this.name = name;
        this.head = head;
        this.employees = new ArrayList<>();
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

    public List<Employee> getEmployees() {
        return employees;
    }
}

class Firm {
    private String name;
    private Employee director;
    private List<Department> departments;

    public Firm(String name, Employee director) {
        this.name = name;
        this.director = director;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public Employee getDirector() {
        return director;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}

public class Task{
    public static void main(String[] args) {
        Employee director = new Employee("Максим", "Андріяшин", 50000);
        Firm firm = new Firm("TechSolutions", director);

        Employee headIT = new Employee("Іван", "Мельник", 40000);
        Department itDept = new Department("IT відділ", headIT);
        itDept.addEmployee(new Employee("Оксана", "Ковальчук", 25000));
        itDept.addEmployee(new Employee("Владислав", "Довгополий", 28000));
        itDept.addEmployee(new Employee("Олексій", "Ткаченко", 42000)); // Цей отримує більше за начальника IT

        Employee headMarketing = new Employee("Анастасія", "Щур", 35000);
        Department marketingDept = new Department("Маркетинг", headMarketing);
        marketingDept.addEmployee(new Employee("Антон", "Білан", 20000));
        marketingDept.addEmployee(new Employee("Марія", "Шевченко", 18000));

        firm.addDepartment(itDept);
        firm.addDepartment(marketingDept);

        System.out.println("Фірма створена: " + firm.getDirector());

        System.out.println("Завдання 1 нетипізований ітератор");
        double maxSalary = firm.getDirector().getSalary();

        Iterator deptIteratorRaw = firm.getDepartments().iterator();
        while (deptIteratorRaw.hasNext()) {
            Department currentDept = (Department) deptIteratorRaw.next();

            if (currentDept.getHead().getSalary() > maxSalary) {
                maxSalary = currentDept.getHead().getSalary();
            }

            Iterator empIteratorRaw = currentDept.getEmployees().iterator();
            while (empIteratorRaw.hasNext()) {
                Employee emp = (Employee) empIteratorRaw.next();
                if (emp.getSalary() > maxSalary) {
                    maxSalary = emp.getSalary();
                }
            }
        }
        System.out.println("Максимальна зарплата у фірмі: " + maxSalary);

        System.out.println("Завдання 2 типізований ітератор");

        Iterator<Department> deptIteratorTyped = firm.getDepartments().iterator();
        while (deptIteratorTyped.hasNext()) {
            Department currentDept = deptIteratorTyped.next();
            double headSalary = currentDept.getHead().getSalary();
            boolean found = false;

            Iterator<Employee> empIteratorTyped = currentDept.getEmployees().iterator();
            while (empIteratorTyped.hasNext()) {
                Employee emp = empIteratorTyped.next();
                if (emp.getSalary() > headSalary) {
                    System.out.println("У відділі \"" + currentDept.getName() +
                            "\" працівник " + emp +
                            " отримує більше за начальника (" + headSalary + ")");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("У відділі \"" + currentDept.getName() + "\" немає таких працівників.");
            }
        }

        System.out.println("Завдання 3 цикл for-each");
        List<Employee> allStaff = new ArrayList<>();

        allStaff.add(firm.getDirector());

        for (Department dept : firm.getDepartments()) {
            allStaff.add(dept.getHead());

            for (Employee emp : dept.getEmployees()) {
                allStaff.add(emp);
            }
        }

        System.out.println("Загальний список співробітників (" + allStaff.size() + " осіб):");
        for (Employee staff : allStaff) {
            System.out.println("- " + staff);
        }
    }
}