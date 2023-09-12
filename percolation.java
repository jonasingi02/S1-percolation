import edu.princeton.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final int top = 0;
    private final boolean[][] opened;
    private final int size;
    private final int bottom;
    private int opensites;
    private final WeightedQuickUnionUF uf;

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
        if (row > N || row < 1 || col > N || col < 1) {
            throw new ArrayIndexOutOfBoundsExeption();
        }
        opened[row-1][col-1] = true;
        openedsites++;

        if (row == 1) {
            uf.union(1, findIndex(row, col));
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

    }


    public static void main(String args[]){
    a[][] = Percolation(2);
    print(a[1][1]);
    }
}
