package example3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortListByTwoFields {
    public static void main(String[] args) {
        List<Book> bookList = Arrays.asList(
            new Book(500, "Core Java", 200, "Kathy Sierra", 1065.5),
            new Book(501, "JSP & Servlets", 350, "Kathy Sierra", 1749.0),
            new Book(502, "Spring in Action", 480, "Craig Walls", 940.75),
            new Book(503, "Pro Angular", 260, "Freeman", 1949.25),
            new Book(504, "HTML CSS", 100, "Thomas Powell", 2317.09),
            new Book(505, "Hibernate in Action", 180, "Gavin King", 889.25)
        );

        System.out.println("Sort List of Book objects by Bookname");

        // Sort by name
        bookList
            .stream()
            .sorted((book1, book2) -> book1.getName().compareToIgnoreCase(book2.getName()))
            .forEach(book -> System.out.println(book));

        // Create Comparators for Name, Author & Cost fields respectively
        System.out.println("\nSort list of book objects by name then by author then by cost");
        Comparator<Book> sortByName = (b1, b2) -> b1.getName().compareToIgnoreCase(b2.getName());
        Comparator<Book> sortByAuhor = (b1, b2) -> b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
        Comparator<Book> sortByCost = (b1, b2) -> Double.compare(b1.getCost(), b2.getCost());

        // Sort by Name then Sort by Author then sort by Cost
        bookList.stream()
        .sorted(sortByName
                .thenComparing(sortByAuhor)
                .thenComparing(sortByCost)
        )
        .forEach(book -> System.out.println(book));
    }
}
