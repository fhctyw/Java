package lab2.task2;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Subject {
    private String nameSubject;
    private Map<Student, Integer> studentMarks;
    private List<LocalDate> dates;

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(final String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public Map<Student, Integer> getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(final Map<Student, Integer> studentMarks) {
        this.studentMarks = studentMarks;
    }

    public List<LocalDate> getDates() {
        return dates;
    }

    public void setDates(final List<LocalDate> dates) {
        this.dates = dates;
    }

    public Subject(final String nameSubject, final Map<Student, Integer> studentMarks, final List<LocalDate> dates) {
        this.nameSubject = nameSubject;
        this.studentMarks = studentMarks;
        this.dates = dates;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(nameSubject).append(" marks:\n");
        for (final Map.Entry<Student, Integer> item : studentMarks.entrySet()) {
            builder.append(item.getKey()).append(" = ").append(item.getValue()).append("/100").append('\n');
        }
        builder.append(nameSubject).append(" meetings:\n");
        for (final LocalDate date : dates) {
            builder.append(date).append('\n');
        }
        return builder.toString();
    }
}
