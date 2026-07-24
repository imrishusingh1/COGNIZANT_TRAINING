import java.util.Arrays;
import java.util.List;

public class DemoForecast {
    public static void main(String[] args) {
        List<Double> data = Arrays.asList(100.0, 102.5, 101.0, 103.0, 104.5, 105.0);
        double alpha = 0.3;
        System.out.println("Historical data: " + data);
        List<Double> sm = Forecast.recursiveSmooth(data, alpha);
        System.out.println("Smoothed series: " + sm);
        List<Double> preds = Forecast.recursiveForecast(data, alpha, 3);
        System.out.println("3-step forecast: " + preds);
    }
}
