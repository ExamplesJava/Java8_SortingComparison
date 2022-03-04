package example2;

import example1.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("George", 10, 10000),
                new Employee("Robert", 12, 15000),
                new Employee("Kathy", 24, 25000)
        );

        // Create Comparator for Name and Salary fields respectively
        Comparator<Employee> sortByName = (e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName());
        Comparator<Employee> sortBySalary = (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());

        // Sort by Name then Sort by Salary
        employees.stream().sorted(sortByName.thenComparing(sortBySalary))
                .forEach(e -> System.out.println(e));
    }
}
