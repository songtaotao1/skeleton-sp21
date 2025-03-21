package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import org.checkerframework.checker.units.qual.A;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE

        int[] testNs = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        AList<Integer> nl = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        for (int n : testNs) {
            SLList<Integer> list = new SLList();
            for (int t = 0; t < n; t++) {
                list.addLast(1);
            }
            Stopwatch timer = new Stopwatch(); // 计时开始
            for (int t = 0; t < 10000; t++) {
                list.getLast();
            }
            double timeInSeconds = timer.elapsedTime(); // 计时结束
            nl.addLast(n);
            times.addLast(timeInSeconds);
            opCounts.addLast(10000);





        }
        printTimingTable(nl, times, opCounts);
    }

}
