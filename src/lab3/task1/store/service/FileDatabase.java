package lab3.task1.store.service;

import lab3.task1.store.Store;

import java.io.*;

public class FileDatabase extends StoreService {
    private String pathDatabase;
    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;
    private IOException ioException;

    public String getPathDatabase() {
        return pathDatabase;
    }

    public void setPathDatabase(final String pathDatabase) {
        this.pathDatabase = pathDatabase;
    }

    public FileDatabase(final Store store) {
        super(store);
        this.pathDatabase = "database";
        try {
            this.fileOutputStream = new FileOutputStream(pathDatabase);
            this.fileInputStream = new FileInputStream(pathDatabase);
        } catch (final FileNotFoundException fileNotFoundException) {
            this.ioException = fileNotFoundException;
        }
    }

    public FileDatabase(final Store store, final String pathDatabase) {
        super(store);
        this.pathDatabase = pathDatabase;
        try {
            this.fileOutputStream = new FileOutputStream(pathDatabase);
            this.fileInputStream = new FileInputStream(pathDatabase);
        } catch (final FileNotFoundException fileNotFoundException) {
            this.ioException = fileNotFoundException;
        }

    }

    private void validate() throws IOException {
        if (ioException != null) {
            throw ioException;
        }
    }

    public void save() throws IOException {
        validate();
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(store);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public void load() throws IOException, ClassNotFoundException {
        validate();
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        final Store storeFromFile = (Store) objectInputStream.readObject();
        this.setStore(storeFromFile);
        objectInputStream.close();
        fileInputStream.close();
    }

//    @Override
//    protected void finalize() throws Throwable {
//        fileInputStream.close();
//        fileOutputStream.close();
//    }
}
