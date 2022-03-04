package example1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    private List<Employee> employees = Arrays.asList(
            new Employee("George", 10, 10000),
            new Employee("Robert", 12, 15000),
            new Employee("Kathy", 24, 25000),
            new Employee("Kathy", 23, 50000)
    );

    /* Simple Sort Before Java8 */
    public void sortWithoutUsingLambda() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /* Simple Sort with Lambdas – Using Java8 to make sorting easy */
    public void sortWithLambdaExpression() {
        // We are using the new sort API added to java.util.List in Java 8 in place of the old Collections.sort API.
        employees.sort((Employee employee1, Employee employee2) -> employee1.getName().compareTo(employee2.getName()));
        employees.forEach(employee -> System.out.println(employee));
    }

    public void sortWithLambdaExpression2() {
        // Podemos simplificar aún más la expresión eliminando las definiciones de tipo, ya que el compilador es capaz de inferirla por sí solo:
        employees.sort((employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));
        employees.forEach(employee -> System.out.println(employee));
    }

    /* Simple Sort Using Instance Method Reference – Using Java8 to make sorting easy */
    public void sortingWithMethodReference() {
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        employees.forEach(employee -> System.out.println(employee));
    }

    /* Sort with multiple attributes using Comparator.comparing() */
    public void sortingWithMultipleAttributeUsingMethodReference() {
        employees.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge));
        employees.forEach(employee -> System.out.println(employee));
    }

    /* Sorting with Stream.sorted() -Using Java8 to make sorting easy */
    public void sortNaturallyUsingStream() {
        List<String> alphabets = Arrays.asList("E", "A", "G");
        List<String> sortedAlphabets = alphabets.stream().sorted().collect(Collectors.toList());
        sortedAlphabets.forEach(item -> System.out.println(item));
    }

    /* Now let’s see an example of a custom Comparator with the sorted() API */
    public void sortingByNameUsingStream() {
        List<Employee> sortedEmployess =
                employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // new example1.Test().sortWithoutUsingLambda();
        // new example1.Test().sortWithLambdaExpression();
        // new example1.Test().sortWithLambdaExpression2();
        // new example1.Test().sortingWithMethodReference();
        // new example1.Test().sortingWithMultipleAttributeUsingMethodReference();
        new Test().sortNaturallyUsingStream();
        new Test().sortingByNameUsingStream();
    }
}
