package lab3.task1.tool;

import java.util.Map;

public class Pair<L, R> {
    private L value1;
    private R value2;

    public L getValue1() {
        return value1;
    }

    public void setValue1(final L value1) {
        this.value1 = value1;
    }

    public R getValue2() {
        return value2;
    }

    public void setValue2(final R value2) {
        this.value2 = value2;
    }

    public Pair() {

    }

    public Pair(final L value1, final R value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public Pair(final Map.Entry<L, R> entry) {
        this.value1 = entry.getKey();
        this.value2 = entry.getValue();
    }

    @Override
    public String toString() {
        return value1 + " " + value2;
    }
}
