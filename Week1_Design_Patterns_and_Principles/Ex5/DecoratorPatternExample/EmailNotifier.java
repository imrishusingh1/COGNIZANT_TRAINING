public class EmailNotifier implements Notifier {
    private final String emailAddress;
    public EmailNotifier(String emailAddress) { this.emailAddress = emailAddress; }

    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL to " + emailAddress + ": " + message);
    }
}
