public class MobileApp implements Observer {
    private final String appName;
    public MobileApp(String appName) { this.appName = appName; }

    @Override
    public void update(String eventType, Object data) {
        System.out.println("[" + appName + "] Push Notification: Stock update - " + data);
    }
}
