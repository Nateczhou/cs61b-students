/**
 * TODO: Fill in the add and floor methods.
 */
public class AListFloorSet implements Lab5FloorSet {
    AList<Double> items;

    public AListFloorSet() {
        items = new AList<>();
    }

    public void add(double x) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) == x) {
                return;
            }
        }
        items.addLastFancy(x);

        return;
    }

    public double floor(double x) {
        double result = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < items.size(); i++) {
            double curr = items.get(i);
            if (curr <= x) {
                if (curr > result) {
                    result = curr;
                }

            }
        }
        return result;
    }
}
