package lab2.task3.service;

import lab2.task2.Group;
import lab2.task2.Student;
import lab2.task2.Subject;
import lab2.task2.University;

import java.security.InvalidParameterException;

public class Service {
    protected University university;

    public Subject getSubjectByName(final String nameGroup, final String nameSubject) {
        for (final Subject subject : getGroupByName(nameGroup).getSubjects()) {
            if (subject.getNameSubject().equals(nameSubject)) {
                return subject;
            }
        }
        throw new InvalidParameterException("No such name subject");
    }
    public Group getGroupByName(final String nameGroup) {
        for (final Group group : university.getGroups()) {
            if (group.getNameGroup().equals(nameGroup)) {
                return group;
            }
        }
        throw new InvalidParameterException("No such name group");
    }

    public Student getStudentByName(final String nameStudent) {
        for (final Group group : university.getGroups()) {
            for (final Student student : group.getStudents()) {
                if (student.getFullName().equals(nameStudent)) {
                    return student;
                }
            }
        }
        throw new InvalidParameterException("No such student");
    }

    public Service(final University university) {
        this.university = university;
    }
}
