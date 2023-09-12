import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class percolation {

    private static final int top = 0;
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
        uf = new WeightedQuickUnionUF(N * N + 2);
        openedsites = 0;
        size = N;
    }

    public void open(int row, int col) {
        if (row > size || row < 1 || col > size || col < 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        opened[row-1][col-1] = true;
        openedsites++;

        if (row == 1) {
            uf.union(0, findIndex(row, col));
        } 
        else {
            if (isOpen(row-1, col)) {
                uf.union(findIndex(row-1, col), findIndex(row, col));
            }
        }

        if (row == size){
            uf.union(findIndex(row, col), bottom);
        }
        else {
            if (isOpen(row+1, col)) {
                uf.union(findIndex(row+1, col), findIndex(row, col));
            }
        }

        if (col != 1) {
            if (isOpen(row, col-1)) {
                uf.union(findIndex(row, col-1), findIndex(row, col));
            }
        }

        if (col != size){
            if (isOpen(row, col+1)) {
                uf.union(findIndex(row, col+1), findIndex(row, col));
            }
        }
    }

    private int findIndex(int row, int col) {
        return size * row-1 + col;
    }

    public boolean isOpen(int row, int col) {
        if (opened[row-1][col-1] == true){
            return true;
        } else {
            return false;
        }
    }
    public boolean isFull(int row, int col) {
        if (opened[row-1][col-1] == false){
            return true;
        } else {
            return false;
        }
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
            System.out.println("The system percolates");
        } else {
            System.out.println("The system does not percolate");
        }

        percolation.open(2, 1);
        percolation.percolates();
        if (percolation.percolates()) {
            System.out.println("The system percolates");
        } else {
            System.out.println("The system does not percolate");
        }

        percolation.open(3, 1);
        percolation.percolates();
        if (percolation.percolates()) {
            System.out.println("The system percolates");
        } else {
            System.out.println("The system does not percolate");
        }
    }
}
