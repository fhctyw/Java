package lab3.task1.store.workers.service;

import lab3.task1.store.workers.Workers;
import lab3.task1.store.workers.human.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class WorkerService {
    protected Workers workers;

    public Workers getWorkers() {
        return workers;
    }

    public void setWorkers(final Workers workers) {
        this.workers = workers;
    }

    public WorkerService(final Workers workers) {
        this.workers = workers;
    }

    public void addWorker(final Employee employee) {
        workers.getEmployees().add(employee);
    }

    public Employee getEmployer(final int index) {
        return workers.getEmployees().get(index);
    }

    public List<Employee> getAllEmployers() {
        return workers.getEmployees();
    }

    public <T> Workers getEmployers(final Class<T> clazz) {
        return new Workers(workers.getEmployees()
                .stream()
                .filter(clazz::isInstance)
                .collect(Collectors.toList()));
    }

    public boolean exist() {
        return workers != null;
    }

    public int count() {
        return workers.getEmployees().size();
    }
}
