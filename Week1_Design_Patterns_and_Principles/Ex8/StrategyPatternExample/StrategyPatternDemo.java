public class StrategyPatternDemo {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        int[] data1 = {64, 34, 25, 12, 22, 11, 90};
        int[] data2 = {64, 34, 25, 12, 22, 11, 90};

        sorter.setStrategy(new BubbleSortStrategy());
        sorter.sort(data1);

        sorter.setStrategy(new QuickSortStrategy());
        sorter.sort(data2);
    }
}
