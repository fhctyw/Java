package lab3.task1.store.database;

import java.io.*;

public abstract class FileTextService {
    protected Object object;
    protected String name;

    public Object getObject() {
        return object;
    }

    public void setObject(final Object object) {
        this.object = object;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }


    public FileTextService(final Object object, final String name) {
        this.object = object;
        this.name = name;
    }

    public FileTextService(final Object object) {
        this(object, object.getClass().getSimpleName().toLowerCase());
    }

    public abstract void save() throws IOException;

    public abstract void load() throws IOException;
}
