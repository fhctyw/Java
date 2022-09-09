package lab2.task3.service;

import lab2.task2.Group;
import lab2.task2.Subject;
import lab2.task2.University;

import java.security.InvalidParameterException;

public class Service {
    protected University university;

    protected Subject getSubjectByName(final String nameGroup, final String nameSubject) {
        for (final Subject subject : getGroupByName(nameGroup).getSubjects()) {
            if (subject.getNameSubject().equals(nameSubject)) {
                return subject;
            }
        }
        throw new InvalidParameterException("No such name subject");
    }
    protected Group getGroupByName(final String nameGroup) {
        for (final Group group : university.getGroups()) {
            if (group.getNameGroup().equals(nameGroup)) {
                return group;
            }
        }
        throw new InvalidParameterException("No such name group");
    }

    public Service(final University university) {
        this.university = university;
    }
}
