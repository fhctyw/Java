package lab3.task1.store.database;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDatabase extends Database {
    public FileDatabase(final FileInputStream fileInputStream, final FileOutputStream fileOutputStream) {
        super(fileOutputStream, fileInputStream);
    }

    public FileDatabase(final FileInputStream fileInputStream) {
        super(fileInputStream);
    }

    public FileDatabase(final FileOutputStream fileOutputStream) {
        super(fileOutputStream);
    }

    public FileDatabase(final String name) {
        super(null, null);
        try {
            setName(name);
        } catch (final IOException ex) {
            throw new NullPointerException(); // or outputStream = inputStream = null, or remove constructor
        }
    }

    public void setName(final String name) throws IOException {
        final Path paths = Paths.get(name);
        outputStream = Files.newOutputStream(paths);
        inputStream = Files.newInputStream(paths);
    }
}
