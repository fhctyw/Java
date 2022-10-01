package lab3.task1.store.workers.service;

import lab3.task1.store.database.FileTextService;
import lab3.task1.store.storage.Good;
import lab3.task1.store.workers.Workers;
import lab3.task1.store.workers.human.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class WorkerFileText extends FileTextService {
    public WorkerFileText(final Object object, final String name) {
        super(object, name);
    }

    public WorkerFileText(final Object object) {
        super(object);
    }

    @Override
    public void save() throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(name));

        final Workers workers = (Workers) object;
        for (final Employee employee : workers.getEmployees()) {

        }

        bufferedWriter.close();
    }

    @Override
    public void load() throws IOException {

    }
}
