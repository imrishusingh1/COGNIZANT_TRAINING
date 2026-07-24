public class InventoryDemo {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product(101, "Laptop", 50, 75000.00));
        manager.addProduct(new Product(102, "Mouse", 200, 850.00));
        manager.addProduct(new Product(103, "Keyboard", 150, 1200.00));

        System.out.println("\n--- Search ---");
        Product found = manager.searchById(102);
        System.out.println("Found: " + found);

        System.out.println("\n--- Update ---");
        manager.updateProduct(101, 45, 72000.00);

        System.out.println("\n--- Delete ---");
        manager.deleteProduct(103);

        System.out.println();
        manager.displayAll();
    }
}
