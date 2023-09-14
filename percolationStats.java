import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;




public class percolationStats {
    private final double[] thresholds;

    public percolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        thresholds = new double[T];
        
        for (int i = 0; i < T; i++) {
            int open_sites = 0;
            percolation percolation = new percolation(N);

            while(!percolation.percolates()) {
                int row = StdRandom.uniform(1, N+1);
                int col = StdRandom.uniform(1, N+1);

                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                    open_sites++;
                }
            }
            double threshold = (double) open_sites / (N * N);
            thresholds[i] = threshold;
        }
    }
    
    public double mean() {
        return StdStats.mean(thresholds);
    }
    
    public double stddev() {
        return StdStats.stddev(thresholds);
    }


    public static void main(String[] args) {
        int N = 70;
        int T = 500;
        for (int i = 1; i < 6; i++) {
            StdOut.println(i + ": N = " + N + " T = " + T);
            Stopwatch stopwatch = new Stopwatch();
            percolationStats stats = new percolationStats(N, T);
            double runtime = stopwatch.elapsedTime();
        
            StdOut.println("Mean: " + stats.mean());
            StdOut.println("Standard Deviation: " + stats.stddev());
            StdOut.println("Runtime: " + runtime + "s\n");

            //T = T * 2;
            N = N * 2;
        }
    }
}
