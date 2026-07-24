// Dependency is INJECTED via constructor - no new keyword inside class
public class CustomerService {
    private final CustomerRepository repository;

    // Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public String getCustomer(int id) {
        return repository.findCustomerById(id);
    }
}
