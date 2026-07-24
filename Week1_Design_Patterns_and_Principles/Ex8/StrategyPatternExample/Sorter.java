import java.util.Arrays;

public class Sorter {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) { this.strategy = strategy; }

    public void sort(int[] array) {
        strategy.sort(array);
        System.out.println("Sorted: " + Arrays.toString(array));
    }
}
