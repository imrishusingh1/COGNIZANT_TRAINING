public class EmployeeBSTDemo {
    public static void main(String[] args) {
        EmployeeBST bst = new EmployeeBST();
        bst.insert(new Employee(105, "Alice", "Engineering", 85000));
        bst.insert(new Employee(102, "Bob", "Marketing", 65000));
        bst.insert(new Employee(108, "Charlie", "Engineering", 92000));
        bst.insert(new Employee(101, "Diana", "HR", 55000));
        bst.insert(new Employee(104, "Eve", "Finance", 72000));

        bst.inOrderTraversal();

        System.out.println("\nSearch ID 104: " + bst.search(104));
        System.out.println("Search ID 999: " + bst.search(999));
        System.out.println("\nBST search is O(log n) on average vs O(n) for linear search.");
    }
}
