package lab3.task1.store.workers.service;

import lab3.task1.store.workers.Workers;
import lab3.task1.store.workers.human.Employee;

import java.util.List;

public class WorkerGet extends WorkerService {
    public WorkerGet(final Workers workers) {
        super(workers);
    }

    public Employee get(final int index) {
        return workers.getEmployees().get(index);
    }

    public List<Employee> getAllEmployers() {
        return workers.getEmployees();
    }
}
