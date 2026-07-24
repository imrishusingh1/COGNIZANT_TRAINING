public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // In real app, this would query a database
        if (id == 1) return "Alice Smith";
        if (id == 2) return "Bob Jones";
        return "Unknown Customer";
    }
}
