package lab3.task1.store.workers;

import lab3.task1.store.workers.human.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class Workers {
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(final List<Employee> employees) {
        this.employees = employees;
    }

    public Workers(final List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        employees.forEach(
                e -> stringBuilder.append(e.getClass().getSimpleName()).append(' ').append(e).append('\n')
        );
        return stringBuilder.toString();
    }
}
