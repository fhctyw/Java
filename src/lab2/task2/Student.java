package lab2.task2;

import java.util.Objects;

public class Student {
    private String fullName;
    private String specialty;
    private String group;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(final String specialty) {
        this.specialty = specialty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(final String group) {
        this.group = group;
    }

    public Student(final String fullName, final String specialty, final String group) {
        this.fullName = fullName;
        this.specialty = specialty;
        this.group = group;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Student student = (Student) o;
        return Objects.equals(fullName, student.fullName) && Objects.equals(specialty, student.specialty) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, specialty, group);
    }

    @Override
    public String toString() {
        return fullName + ", " + specialty + ", " + group;
    }
}
