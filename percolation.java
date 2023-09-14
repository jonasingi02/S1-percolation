import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class percolation {

    private final boolean[][] opened;
    private final int size;
    private final int bottom;
    private int openedsites;
    private final WeightedQuickUnionUF uf;
    private boolean a;

    public percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        opened = new boolean[N][N];
        bottom = N * N;
        uf = new WeightedQuickUnionUF((N * N) + 2);
        openedsites = 0;
        size = N;
    }

    public void open(int row, int col) {
        if (row+1 > size || row < 0 || col+1 > size || col < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        opened[row][col] = true;
        openedsites++;

        if (row == 0) {
            uf.union(0, findIndex(row, col));
        } 
        else if (isOpen(row-1, col)) {
            uf.union(findIndex(row-1, col), findIndex(row, col));
        }

        if (row == size-1){
            uf.union(findIndex(row, col), bottom);
        }
        else if (isOpen(row+1, col)) {
            uf.union(findIndex(row+1, col), findIndex(row, col));
        }

        if (col != 0) {
            if (isOpen(row, col-1)) {
                uf.union(findIndex(row, col-1), findIndex(row, col));
            }
        }

        if (col != size-1){
            if (isOpen(row, col+1)) {
                uf.union(findIndex(row, col+1), findIndex(row, col));
            }
        }
    }

    private int findIndex(int row, int col) {
        return size * (row) + col+1;
    }

    public boolean isOpen(int row, int col) {
        return opened[row][col];
    }
    public boolean isFull(int row, int col) {
        return !(opened[row][col] == false);
    }
    
    public int numberOfOpenSites() {
        return openedsites;
    }

    public boolean percolates() {
        a = uf.connected(0,bottom);
        return a;
    }


    public static void main(String args[]){
        percolation percolation = new percolation(3);

        percolation.open(1, 1);
        percolation.percolates();
        if (percolation.percolates()) {
            StdOut.println("The system percolates");
        } else {
            StdOut.println("The system does not percolate");
        }

        percolation.open(2, 1);
        percolation.percolates();
        if (percolation.percolates()) {
            StdOut.println("The system percolates");
        } else {
            StdOut.println("The system does not percolate");
        }

        percolation.open(3, 1);
        percolation.percolates();
        if (percolation.percolates()) {
            StdOut.println("The system percolates");
        } else {
            StdOut.println("The system does not percolate");
        }
    }
}
