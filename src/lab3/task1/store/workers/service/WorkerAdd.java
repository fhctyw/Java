package lab3.task1.store.workers.service;

import lab3.task1.store.workers.Workers;
import lab3.task1.store.workers.human.Employee;

public class WorkerAdd extends WorkerService {
    public WorkerAdd(final Workers workers) {
        super(workers);
    }

    public void add(final Employee employee) {
        workers.getEmployees().add(employee);
    }
}
