package lab2.task4;

import lab2.task2.Group;
import lab2.task2.Student;
import lab2.task2.Subject;
import lab2.task2.University;
import lab2.task3.service.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Journal {
    private University university;
    private Student student;
    private Map<String, Integer> marks;

    public Student getStudent() {
        return student;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(final University university) {
        this.university = university;
    }

    public void setStudent(final Student student) {
        this.student = student;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(final Map<String, Integer> marks) {
        this.marks = marks;
    }

    public Journal(final University university, final Student student, final Map<String, Integer> marks) {
        this.university = university;
        this.student = student;
        this.marks = marks;
    }

    public Journal(final String student, final University university) {
        this.university = university;
        final Service service = new Service(university);
        this.student = service.getStudentByName(student);

        this.marks = new HashMap<String, Integer>();
        for (final Group group : university.getGroups()) {
            if (group.getStudents().contains(this.student)) {
                for (final Subject subject : group.getSubjects()) {
                    marks.put(subject.getNameSubject(), subject.getStudentMarks().get(this.student));
                }
            }
        }
    }
    public void changeMarkBySubjectName(final String nameSubject, final Integer newValue) {
        marks.put(nameSubject, newValue);
    }

    public static Map<String, Integer> getMarksByStudent(final University university, final String nameStudent) {
        final Journal journal = new Journal(nameStudent, university);
        return journal.getMarks();
    }
    public static Map<Student, Map<String, Integer>> getAllMarksAllStudents(final University university) {
        final Map<Student, Map<String, Integer>> map = new HashMap<>();
        for (final Group group : university.getGroups()) {
            for (final Subject subject : group.getSubjects()) {
                for (final Map.Entry<Student, Integer> item : subject.getStudentMarks().entrySet()) {
                    final Journal journal = new Journal(item.getKey().getFullName(), university);
                    map.put(item.getKey(), journal.getMarks());
                }
            }
        }
        return map;
    }

    public static List<Integer> getMarksBySubject(final University university, final String nameSubject) {
        final List<Integer> marks = new ArrayList<>();
        for (final Group group : university.getGroups()) {
            for (final Subject subject : group.getSubjects()) {
                if (subject.getNameSubject().equals(nameSubject)) {
                    marks.addAll(subject.getStudentMarks().values());
                }
            }
        }
        return marks;
    }
}
