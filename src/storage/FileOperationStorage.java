package storage;

import console.ConsoleWriter;
import console.Writer;
import operation.Operation;

import java.io.*;

public class FileOperationStorage {
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

    public void writeFromFile(Operation result) {
        try {
            FileWriter fileWriter = new FileWriter("storage.txt", true);
            fileWriter.write(result.toString());
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


