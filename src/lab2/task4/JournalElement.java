package lab2.task4;

import lab2.task2.Student;
import lab2.task2.Subject;

import java.util.Map;

public class JournalElement {
    private Map<String, Integer> markPerSubject;
    private int markForSemester;

    public Map<String, Integer> getMarkPerSubject() {
        return markPerSubject;
    }

    public void setMarkPerSubject(final Map<String, Integer> markPerSubject) {
        this.markPerSubject = markPerSubject;
    }

    public int getMarkForSemester() {
        return markForSemester;
    }

    public void setMarkForSemester(final int markForSemester) {
        this.markForSemester = markForSemester;
    }

    public JournalElement(final Map<String, Integer> markPerSubject, final int markForSemester) {
        this.markPerSubject = markPerSubject;
        this.markForSemester = markForSemester;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (final String nameSubject : markPerSubject.keySet()) {
             builder.append(nameSubject).append(" ").append(markPerSubject.get(nameSubject)).append('\n');
        }
        return builder.toString();
    }
}
