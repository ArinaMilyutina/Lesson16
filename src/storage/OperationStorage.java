package storage;

import entity.Operation;

import java.util.List;

public interface OperationStorage {
    void saveOperation(Operation operation);
    public List<Operation> findAll();
}
