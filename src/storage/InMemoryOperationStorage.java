package storage;


import entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOperationStorage implements OperationStorage {
    private long ids = 1;
    private final List<Operation> operationList = new ArrayList<>();


    @Override
    public void saveOperation(Operation operation) {
        operation.setId(ids++);
        operationList.add(operation);

    }

    public List<Operation> findAll() {
        return new ArrayList<>(operationList);
    }

}
