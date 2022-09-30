package lab3.task1.store.database;

import java.io.*;

public class Database implements StoreIO {
    protected OutputStream outputStream;
    protected InputStream inputStream;

    public Database(final InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Database(final OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public Database(final OutputStream outputStream, final InputStream inputStream) {
        this.outputStream = outputStream;
        this.inputStream = inputStream;
    }

    @Override
    public boolean save(final Object serializableObject) {
        try {
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(serializableObject);
            objectOutputStream.close();
            return true;
        } catch (final IOException ioException) {
            return false;
        }
    }

    @Override
    public Object load() {
        try {
            final ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            final Object obj = objectInputStream.readObject();
            objectInputStream.close();
            return obj;
        } catch (final IOException | ClassNotFoundException ex) {
            return null; // In doubt, null or throw exception, that will be caught by someone
        }
    }
}
