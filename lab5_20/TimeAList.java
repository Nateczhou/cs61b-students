import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Class that collects timing information about AList construction.
 */
public class TimeAList {
    private static void printTimingTable(List<Integer> Ns, List<Double> times, List<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }


    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        List<Integer> Ns = new ArrayList<>();
        List<Double> times = new ArrayList<>();
        List<Integer> opCounts = new ArrayList<>();
        int iter = 15;
        Random rand = new Random();

        for (int i = 0; i <= iter; i++) {
            int N = (int) Math.pow(2, i) * 1000;
            Stopwatch watch = new Stopwatch();
            AList<Integer> list = new AList<>();
            for (int j = 0; j < N; j++) {
                list.addLastFancy(100);
            }
            double time = watch.elapsedTime();
            Ns.add(N);
            times.add(time);
            opCounts.add(N);
        }

        printTimingTable(Ns, times, opCounts);
    }


}
