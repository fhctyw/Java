package lab3.task1.store.workers.service;

import lab3.task1.store.workers.Workers;

public class WorkerChecker extends WorkerService {
    public WorkerChecker(final Workers workers) {
        super(workers);
    }

    public boolean exist() {
        return workers != null;
    }

    public int count() {
        return workers.getEmployees().size();
    }
}
