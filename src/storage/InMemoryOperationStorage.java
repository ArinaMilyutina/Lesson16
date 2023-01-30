package storage;


import entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOperationStorage implements OperationStorageList {
    private long ids = 1;
    private final List<Operation> operationList = new ArrayList<>();


    @Override
    public void saveList(Operation operation) {
        operation.setId(ids++);
        operationList.add(operation);

    }


    @Override
    public List<Operation> findAll() {
        return new ArrayList<>(operationList);
    }
}
