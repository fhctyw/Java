package lab3.task1.store.workers.human;

public class Manager implements Owner {
    private String name;

    public Manager(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
