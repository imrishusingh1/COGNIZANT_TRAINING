import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<Product> inventory = new ArrayList<>();

    public void addProduct(Product product) {
        inventory.add(product);
        System.out.println("Added: " + product);
    }

    public void updateProduct(int id, int newQty, double newPrice) {
        for (Product p : inventory) {
            if (p.getProductId() == id) {
                p.setQuantity(newQty);
                p.setPrice(newPrice);
                System.out.println("Updated: " + p);
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
    }

    public void deleteProduct(int id) {
        inventory.removeIf(p -> p.getProductId() == id);
        System.out.println("Deleted product with ID: " + id);
    }

    public Product searchById(int id) {
        for (Product p : inventory) {
            if (p.getProductId() == id) return p;
        }
        return null;
    }

    public void displayAll() {
        System.out.println("--- Current Inventory ---");
        inventory.forEach(System.out::println);
    }
}
