package service;

import entity.Operation;
import storage.FileStorage;
import storage.InMemoryOperationStorage;
import storage.OperationStorage;

import java.util.List;
import java.io.Externalizable;
import java.util.Optional;

public class CalculatorService {
    private final InMemoryOperationStorage storageList = new InMemoryOperationStorage();
    private final OperationStorage storageFile = new FileStorage();

    public Optional<Operation> calculate(Operation operation) {
        switch (operation.getOperationNumber()) {
            case "1" -> {
                operation.setResult(sum(operation.getNumber1(), operation.getNumber2()));
                storageList.saveOperation(operation);
                storageFile.saveOperation(operation);
                return Optional.of(operation);
            }
            case "2" -> {
                operation.setResult(div(operation.getNumber1(), operation.getNumber2()));
                storageList.saveOperation(operation);
                storageFile.saveOperation(operation);
                return Optional.of(operation);
            }
            case "3" -> {
                operation.setResult(mul(operation.getNumber1(), operation.getNumber2()));
                storageList.saveOperation(operation);
                storageFile.saveOperation(operation);
                return Optional.of(operation);
            }
            case "4" -> {
                operation.setResult(res(operation.getNumber1(), operation.getNumber2()));
                storageList.saveOperation(operation);
                storageFile.saveOperation(operation);
                return Optional.of(operation);
            }
        }
        return Optional.empty();

    }

    private double sum(double a, double b) {
        return a + b;
    }


    private double res(double a, double b) {
        return a - b;
    }


    private double div(double a, double b) {
        return a / b;
    }


    private double mul(double a, double b) {
        return a * b;
    }

    public List<Operation> showOperation() {
        return storageList.findAll();
    }
}
