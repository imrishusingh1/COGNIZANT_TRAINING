import java.util.Arrays;
import java.util.Comparator;

public class OrderSorter {

    // Bubble Sort - O(n^2) - for understanding
    public static Order[] bubbleSortByPrice(Order[] orders) {
        Order[] arr = Arrays.copyOf(orders, orders.length);
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j].getTotalPrice() > arr[j + 1].getTotalPrice()) {
                    Order tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
                }
        return arr;
    }

    // Quick Sort - O(n log n) - for performance
    public static Order[] quickSortByPrice(Order[] orders) {
        Order[] arr = Arrays.copyOf(orders, orders.length);
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].getTotalPrice() <= pivot) {
                i++;
                Order t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        }
        Order t = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = t;
        return i + 1;
    }

    // Using Java built-in (preferred in production)
    public static Order[] sortByPriceBuiltIn(Order[] orders) {
        Order[] arr = Arrays.copyOf(orders, orders.length);
        Arrays.sort(arr, Comparator.comparingDouble(Order::getTotalPrice));
        return arr;
    }
}
