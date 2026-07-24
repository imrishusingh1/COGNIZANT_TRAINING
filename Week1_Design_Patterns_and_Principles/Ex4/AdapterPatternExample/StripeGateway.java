// Third-party Stripe class (cannot be modified)
public class StripeGateway {
    public void makeCharge(double amountInCents) {
        System.out.println("Stripe: Charging " + amountInCents + " cents via Stripe API");
    }
}
