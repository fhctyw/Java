package lab1;

import java.util.Random;

public class Matrix {
    private int row;
    private int col;
    private double[][] matrix;

    public Matrix(final int row, final int col) {
        this.row = row;
        this.col = col;
        matrix = new double[row][col];
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                final String line = matrix[i][j] + " ";
                builder.append(line);
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    public static Matrix transpose(final Matrix m) {
        final Matrix newMatrix = new Matrix(m.col, m.row);
        for (int i = 0; i < newMatrix.row; i++) {
            for (int j = 0; j < newMatrix.col; j++) {
                newMatrix.matrix[i][j] = m.matrix[j][i];
            }
        }
        return newMatrix;
    }

    public  static Matrix randMatrix(final int row, final int col) {
        final Matrix matrix = new Matrix(row, col);
        final Random random = new Random();
        for (int i = 0; i < matrix.row; i++) {
            for (int j = 0; j < matrix.col; j++) {
                matrix.matrix[i][j] = random.nextInt(0, 9);
            }
        }
        return matrix;
    }

}