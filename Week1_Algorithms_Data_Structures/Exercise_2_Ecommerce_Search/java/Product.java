import java.util.Objects;

public class Product {
    public final String id;
    public final String title;
    public final String description;

    public Product(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String combined() {
        return (title == null ? "" : title) + " " + (description == null ? "" : description);
    }

    @Override
    public String toString() {
        return id + ": " + title + " - " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
