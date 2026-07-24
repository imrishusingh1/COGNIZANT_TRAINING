public class TradingBot implements Observer {
    private final String botName;
    public TradingBot(String botName) { this.botName = botName; }

    @Override
    public void update(String eventType, Object data) {
        System.out.println("[" + botName + "] Analyzing market signal: " + data + " -> Executing trade strategy");
    }
}
