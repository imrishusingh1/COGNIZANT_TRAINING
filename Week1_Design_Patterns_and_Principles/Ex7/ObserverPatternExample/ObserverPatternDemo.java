public class ObserverPatternDemo {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        MobileApp zerodha = new MobileApp("Zerodha");
        MobileApp groww = new MobileApp("Groww");
        TradingBot bot = new TradingBot("AlgoBot-v1");

        market.registerObserver(zerodha);
        market.registerObserver(groww);
        market.registerObserver(bot);

        System.out.println("\n--- Stock price update 1 ---");
        market.setStockPrice("RELIANCE", 2450.75);

        System.out.println("\n--- Groww unsubscribes ---");
        market.deregisterObserver(groww);

        System.out.println("\n--- Stock price update 2 ---");
        market.setStockPrice("TCS", 3890.50);
    }
}
