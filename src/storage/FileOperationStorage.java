package storage;


import console.util.ConsoleWriter;
import console.util.Writer;
import entity.Operation;

import java.io.*;

public class FileOperationStorage implements OperationStorageFile {
    private final Writer writer = new ConsoleWriter();

    public void checkFile() {
        File file = new File("storage.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException();
            }
        }
    }

    public void saveFile(Operation operation) {
        try {
            FileWriter fileWriter = new FileWriter("storage.txt", true);
            fileWriter.write(operation.toString() + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFromFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("storage.txt"));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                writer.writer(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}


