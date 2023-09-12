import edu.princeton.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final int top = 0;
    private final boolean[][] opened;
    private final int size;
    private final int bottom;
    private int opensites;
    private final WeightedQuickUnionUF gf;

    public static boolean[][] Percolation(int N) {
        if (n <= 0) {
            throw new IllegalArgumentExeption();
        }
        opened = new boolean[N][N];
        bottom = N * N;
        qf = new WeightedQuickUnionUF(N * N + 2);
        openedsites = 0;
        size = N;
    }

    public void open(int row, int col) {
        if (row > N || col > N) {
            throw new ArrayIndexOutOfBoundsExeption();
        }
        opened[row-1][col-1] = true;
        openedsites++;
    }
    //     public boolean isOpen(int row, int col) 
    //     public boolean isFull(int row, int col) 
    //     public int numberOfOpenSites() 
    //     public boolean percolates() 
    //     public static void main(String[] args)


    public static void main(String args[]){
    a[][] = Percolation(2);
    print(a[1][1]);
    }
}
