public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier("admin@example.com");
        notifier = new SMSNotifierDecorator(notifier, "+91-9876543210");
        notifier = new SlackNotifierDecorator(notifier, "#alerts");

        System.out.println("--- Sending alert notification ---");
        notifier.send("Server CPU usage exceeded 90%!");
    }
}
