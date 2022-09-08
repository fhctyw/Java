package lab1;

public class Task5 {
	
	public static void main(final String[] args) {

		final Matrix matrix = Matrix.randMatrix(2, 3);
		System.out.println("Standard matrix\n" + matrix);
		System.out.println("Transpose matrix\n" + Matrix.transpose(matrix));
	}
}
