package lab3.task1.store.workers.service;

import lab3.task1.store.workers.Workers;
import lab3.task1.store.workers.human.Employee;

public class WorkerPut extends WorkerService {
    public WorkerPut(final Workers workers) {
        super(workers);
    }

    public void put(final Employee employee) {
        workers.getEmployees().add(employee);
    }
}
