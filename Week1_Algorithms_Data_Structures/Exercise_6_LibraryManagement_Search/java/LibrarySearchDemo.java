import java.util.Arrays;
import java.util.Comparator;

public class LibrarySearchDemo {
    public static void main(String[] args) {
        Book[] books = {
            new Book(105, "Clean Code", "Robert Martin"),
            new Book(101, "Design Patterns", "Gang of Four"),
            new Book(108, "Effective Java", "Joshua Bloch"),
            new Book(103, "Java Concurrency", "Brian Goetz"),
            new Book(102, "Spring in Action", "Craig Walls"),
        };

        // Linear search (works unsorted)
        System.out.println("=== Linear Search ===");
        Book result = LibrarySearch.linearSearch(books, 103);
        System.out.println("Search ID 103: " + result);

        // Sort before binary search
        Arrays.sort(books, Comparator.comparingInt(Book::getBookId));

        System.out.println("\n=== Binary Search (sorted array) ===");
        result = LibrarySearch.binarySearch(books, 103);
        System.out.println("Search ID 103: " + result);
        result = LibrarySearch.binarySearch(books, 999);
        System.out.println("Search ID 999: " + result);

        System.out.println("\nConclusion: Binary Search O(log n) is faster but needs sorted data.");
        System.out.println("For large libraries, Binary Search is strongly preferred.");
    }
}
