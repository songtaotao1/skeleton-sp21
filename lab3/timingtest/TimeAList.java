package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE

        int[] testNs = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000}; // 预设实验规模

        AList<Integer> Ns = new AList<>();  // 存储 N 值
        AList<Double> times = new AList<>();  // 存储时间
        AList<Integer> opCounts = new AList<>();  // 存储操作次数（# ops）

        for (int N : testNs) {
            AList<Integer> ts = new AList<>(); // 重新创建 AList
            Stopwatch timer = new Stopwatch(); // 计时开始

            for (int i = 0; i < N; i++) {
                ts.addLast(1);
            }

            double timeInSeconds = timer.elapsedTime(); // 计时结束

            Ns.addLast(N);  // 记录 N
            times.addLast(timeInSeconds);  // 记录时间
            opCounts.addLast(N);  // 记录操作次数（等于 N）
        }

        // 调用 printTimingTable() 打印结果
        printTimingTable(Ns, times, opCounts);
    }

}
