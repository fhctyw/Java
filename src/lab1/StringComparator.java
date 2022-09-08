package lab1;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {

    private char symbol;

    public StringComparator(final char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(final char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compare(final String s1, final String s2) {
        final long l1 = s1.chars().filter(ch -> ch == symbol).count();
        final long l2 = s2.chars().filter(ch -> ch == symbol).count();

        return Long.compare(l1, l2) * -1;
    }
}