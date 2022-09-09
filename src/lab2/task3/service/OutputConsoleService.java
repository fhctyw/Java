package lab2.task3.service;

import lab2.task2.Group;
import lab2.task2.Student;
import lab2.task2.Subject;
import lab2.task2.University;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OutputConsoleService extends Service {
    public OutputConsoleService(final University university) {
        super(university);
    }

    public void displayGroupStudentsByName(final String nameGroup) {
        final List<Student> students = getGroupByName(nameGroup).getStudents();
        students.sort(Comparator.comparing(Student::getFullName));
        students.forEach(System.out::println);
    }

    public void displayStudentsBySubject(final String nameSubject) {
        for (final Group group : university.getGroups()) {
            final Subject subject = getSubjectByName(group.getNameGroup(), nameSubject);
            subject.getStudentMarks().keySet().forEach(System.out::println);
        }
    }
}
