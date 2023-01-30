package service;

import entity.Operation;
import storage.FileOperationStorage;
import storage.InMemoryOperationStorage;
import storage.OperationStorageFile;
import storage.OperationStorageList;

import java.util.List;

public class CalculatorService {
    private final OperationStorageList storageList = new InMemoryOperationStorage();
    private final OperationStorageFile storageFile = new FileOperationStorage();

    public Operation calculate(Operation operation) {
        switch (operation.getOperationNumber()) {
            case "1" -> {
                operation.setResult(sum(operation.getNumber1(), operation.getNumber2()));
                storageList.saveList(operation);
                storageFile.saveFile(operation);
                return operation;

            }
            case "2" -> {
                operation.setResult(div(operation.getNumber1(), operation.getNumber2()));
                storageList.saveList(operation);
                storageFile.saveFile(operation);
                return operation;
            }
            case "3" -> {
                operation.setResult(mul(operation.getNumber1(), operation.getNumber2()));
                storageList.saveList(operation);
                storageFile.saveFile(operation);
                return operation;
            }
            case "4" -> {
                operation.setResult(res(operation.getNumber1(), operation.getNumber2()));
                storageList.saveList(operation);
                storageFile.saveFile(operation);
                return operation;
            }
        }
        return null;

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

    public List<Operation> showHistoryList() {
        return storageList.findAll();
    }
}
