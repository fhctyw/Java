package lab2.task2;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String nameUniversity;
    private List<Group> groups;

    public String getNameUniversity() {
        return nameUniversity;
    }

    public void setNameUniversity(final String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(final List<Group> groups) {
        this.groups = groups;
    }

    public University(final String nameUniversity, final List<Group> groups) {
        this.nameUniversity = nameUniversity;
        this.groups = groups;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(nameUniversity);
        builder.append(":\n");
        for (final Group group :
                groups) {
            builder.append(group).append('\n');
        }
        return builder.toString();
    }
}
