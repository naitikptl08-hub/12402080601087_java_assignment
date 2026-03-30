// Program 2: Matrix Class with Constructors, Transpose and Multiplication

public class Matrix {

    private int[][] data;
    private int rows, cols;

    // Constructor 1: empty matrix of given size
    Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    // Constructor 2: from 2D array
    Matrix(int[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = data;
    }

    // Display the matrix
    public void display() {
        for (int[] row : data) {
            for (int val : row)
                System.out.printf("%4d", val);
            System.out.println();
        }
    }

    // Transpose: swap rows and columns
    public Matrix transpose() {
        Matrix result = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.data[j][i] = data[i][j];
        return result;
    }

    // Multiply this matrix with another
    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows)
            throw new IllegalArgumentException("Incompatible matrix sizes for multiplication.");

        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < other.cols; j++)
                for (int k = 0; k < this.cols; k++)
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
        return result;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] b = {{7, 8}, {9, 10}, {11, 12}};

        Matrix matA = new Matrix(a);
        Matrix matB = new Matrix(b);

        System.out.println("Matrix A (2x3):");
        matA.display();

        System.out.println("\nTranspose of A (3x2):");
        matA.transpose().display();

        System.out.println("\nMatrix B (3x2):");
        matB.display();

        System.out.println("\nA x B (2x2):");
        matA.multiply(matB).display();
    }
}