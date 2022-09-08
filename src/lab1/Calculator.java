package lab1;

public class Calculator {

    public static long mult(final long n1, final long n2) {
        return n1*n2;
    }

    public static CustomDouble mult(final CustomDouble n1, final CustomDouble n2) {
        return new CustomDouble(n1.toDouble()*n1.toDouble());
    }

    public static long div(final long n1, final long n2) {
        if (n2 == 0) {
            return 0;
        }
        return n1/n2;
    }

    public static CustomDouble div(final CustomDouble n1, final CustomDouble n2) {
        if (n2.equals(new CustomDouble(0, 0))) {
            return new CustomDouble(0, 0);
        }
        return new CustomDouble(n1.toDouble()/n2.toDouble());
    }
}
