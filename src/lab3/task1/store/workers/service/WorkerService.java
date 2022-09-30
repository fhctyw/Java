package lab3.task1.store.workers.service;

import lab3.task1.store.workers.Workers;

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
}
