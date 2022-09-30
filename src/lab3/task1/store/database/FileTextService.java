package lab3.task1.store.database;

import java.io.*;

public abstract class FileTextService {
    protected Object object;
    protected String name;
    protected BufferedReader bufferedReader;
    protected BufferedWriter bufferedWriter;

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

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(final BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setBufferedWriter(final BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public FileTextService(final Object object, final String name) {
        this.object = object;
        this.name = name;
        try {
            this.bufferedReader = new BufferedReader(new FileReader(name));
            this.bufferedWriter = new BufferedWriter(new FileWriter(name));
        } catch (final IOException ioException) {
            this.bufferedReader = null;
            this.bufferedWriter = null;
        }
    }

    public FileTextService(final Object object) {
        this(object, object.getClass().getSimpleName().toLowerCase());
    }

    public abstract void save() throws IOException;

    public abstract void load() throws IOException;
}
