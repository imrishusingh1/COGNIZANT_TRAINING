import java.util.ArrayList;
import java.util.List;

public class Forecast {
    public static List<Double> recursiveSmooth(List<Double> data, double alpha) {
        int n = data.size();
        List<Double> out = new ArrayList<>();
        return helper(0, data, alpha, out);
    }

    private static List<Double> helper(int i, List<Double> data, double alpha, List<Double> acc) {
        if (i >= data.size()) return acc;
        double s;
        if (i == 0) s = data.get(0);
        else s = alpha * data.get(i) + (1 - alpha) * acc.get(acc.size() - 1);
        acc.add(s);
        return helper(i + 1, data, alpha, acc);
    }

    public static List<Double> recursiveForecast(List<Double> data, double alpha, int steps) {
        if (data == null || data.isEmpty()) return new ArrayList<>();
        List<Double> sm = recursiveSmooth(data, alpha);
        double last = sm.get(sm.size() - 1);
        List<Double> preds = new ArrayList<>();
        for (int i = 0; i < steps; i++) preds.add(last);
        return preds;
    }
}
