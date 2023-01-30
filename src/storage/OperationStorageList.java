package storage;

import entity.Operation;

import java.util.List;

public interface OperationStorageList {
    void saveList(Operation o);

    List<Operation> findAll();


}
