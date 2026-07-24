public class SlackNotifierDecorator extends NotifierDecorator {
    private final String slackChannel;
    public SlackNotifierDecorator(Notifier notifier, String slackChannel) {
        super(notifier);
        this.slackChannel = slackChannel;
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Posting to Slack channel " + slackChannel + ": " + message);
    }
}
