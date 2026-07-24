import java.util.Arrays;
import java.util.List;

public class DemoSearch {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("p1", "Wireless Mouse", "Ergonomic wireless mouse with long battery life"),
            new Product("p2", "Gaming Laptop", "High performance gaming laptop with RTX GPU"),
            new Product("p3", "Waterproof Jacket", "Lightweight waterproof jacket for hiking"),
            new Product("p4", "Noise Cancelling Headphones", "Over-ear headphones with active noise cancellation"),
            new Product("p5", "Mechanical Keyboard", "RGB mechanical keyboard with blue switches"),
            new Product("p6", "Wireless Charger", "Fast wireless charging pad for smartphones"),
            new Product("p7", "Smartwatch", "Water-resistant smartwatch with heart-rate monitor"),
            new Product("p8", "Running Shoes", "Breathable running shoes with foam support")
        );

        InvertedIndex idx = new InvertedIndex();
        idx.buildFromProducts(products);

        String[] queries = {"wireless mouse", "waterproof jacket", "gaming laptop", "wireless charger"};
        for (String q : queries) {
            System.out.println("Query: " + q);
            List<InvertedIndex.Result> res = idx.search(q, 5);
            for (InvertedIndex.Result r : res) {
                System.out.printf("- %s: %s (%.3f)%n", r.id, r.text, r.score);
            }
            System.out.println();
        }
    }
}
