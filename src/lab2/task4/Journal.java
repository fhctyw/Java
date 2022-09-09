package lab2.task4;

import lab2.task2.Group;
import lab2.task2.Student;
import lab2.task2.Subject;
import lab2.task2.University;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Journal {
    private Map<Student, JournalElement> elements;

    public Map<Student, JournalElement> getElements() {
        return elements;
    }

    public void setElements(final Map<Student, JournalElement> elements) {
        this.elements = elements;
    }

    public Journal(final University university) {
        final Map<Student, JournalElement> elements = new HashMap<>();
        for (final Group group : university.getGroups()) {
            final Map<String, Integer> marks = new HashMap<>();
            for (final Student student : group.getStudents()) {
                group.getSubjects().forEach(subject -> marks.put(student.getFullName(), subject.getStudentMarks().get(student)));
            }
        }
    }
}
