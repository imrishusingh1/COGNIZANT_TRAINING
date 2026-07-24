public class DependencyInjectionDemo {
    public static void main(String[] args) {
        // Dependency injected from outside - loose coupling
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        System.out.println("Customer 1: " + service.getCustomer(1));
        System.out.println("Customer 2: " + service.getCustomer(2));
        System.out.println("Customer 9: " + service.getCustomer(9));

        System.out.println("\nBenefit: To use a mock repo in tests, just inject a different implementation!");
    }
}
