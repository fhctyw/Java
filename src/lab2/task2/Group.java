package lab2.task2;

import java.util.List;

public class Group {
    private String nameGroup;
    private List<Student> students;
    private List<Subject> subjects;

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(final String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(final List<Student> students) {
        this.students = students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(final List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Group(final String nameGroup, final List<Student> students, final List<Subject> subjects) {
        this.nameGroup = nameGroup;
        this.students = students;
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(nameGroup).append('\n');
        for (final Subject subject : subjects) {
            builder.append(subject).append('\n');
        }
        return builder.toString();
    }
}
