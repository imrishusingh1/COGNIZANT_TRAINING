import java.util.Arrays;

public class SortingDemo {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 5000.00),
            new Order(2, "Bob", 1500.00),
            new Order(3, "Charlie", 8500.00),
            new Order(4, "Diana", 3200.00),
            new Order(5, "Eve", 750.00)
        };

        System.out.println("=== Bubble Sort by Price ===");
        Arrays.stream(OrderSorter.bubbleSortByPrice(orders)).forEach(System.out::println);

        System.out.println("\n=== Quick Sort by Price ===");
        Arrays.stream(OrderSorter.quickSortByPrice(orders)).forEach(System.out::println);

        System.out.println("\nAnalysis: Quick Sort O(n log n) is preferred for large datasets.");
        System.out.println("Bubble Sort O(n^2) is only suitable for very small arrays.");
    }
}
