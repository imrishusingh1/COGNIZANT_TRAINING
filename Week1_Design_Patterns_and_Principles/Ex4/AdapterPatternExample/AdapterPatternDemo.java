public class AdapterPatternDemo {
    public static void main(String[] args) {
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        stripe.processPayment(99.99);

        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        paypal.processPayment(149.50);

        System.out.println("Both gateways processed through unified PaymentProcessor interface.");
    }
}
