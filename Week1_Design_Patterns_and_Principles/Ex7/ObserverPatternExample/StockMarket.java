public class StockMarket extends Subject {
    private String stockSymbol;
    private double price;

    public void setStockPrice(String symbol, double price) {
        this.stockSymbol = symbol;
        this.price = price;
        System.out.println("[StockMarket] " + symbol + " price changed to $" + price);
        notifyObservers("PRICE_CHANGE", symbol + ":" + price);
    }
}
