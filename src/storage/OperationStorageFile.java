package storage;

import entity.Operation;

public interface OperationStorageFile {
    void checkFile();

    void saveFile(Operation operation);

    void readFromFile();
}
