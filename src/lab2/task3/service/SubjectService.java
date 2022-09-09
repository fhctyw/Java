package lab2.task3.service;

import lab2.task2.Group;
import lab2.task2.Student;
import lab2.task2.Subject;
import lab2.task2.University;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubjectService extends Service{
    public SubjectService(final University university) {
        super(university);
    }

    private Group getGroupByNameGroup(final String nameGroup) {
        for (final Group group : university.getGroups()) {
            if (group.getNameGroup().equals(nameGroup))
                return group;
        }
        throw new InvalidParameterException("No such name");
    }

    public void addSubject(final String nameGroup, final Subject subject) {
        final Group group = getGroupByNameGroup(nameGroup);
        final List<Subject> subjects = new ArrayList<>(group.getSubjects());
        subjects.add(subject);
        group.setSubjects(subjects);

    }
    public void addSubject(final String nameGroup, final String nameSubject) {
        final Group group = getGroupByNameGroup(nameGroup);
        final List<Student> students = group.getStudents();
        final Map<Student, Integer> map = new HashMap<>();
        for (final Student student : students) {
            map.put(student, 0);
        }
        final Subject subject = new Subject(nameSubject, map, new ArrayList<>());
        addSubject(nameGroup, subject);
    }
}
