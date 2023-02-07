package storage;


import entity.Operation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JBDCOperationStorage implements OperationStorage {


    @Override
    public void saveOperation(Operation operation) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "arinemiller22")) {
            PreparedStatement preparedStatement = connection.prepareStatement("  insert into \"Operations\" values (default,?,?,?,?);");
            preparedStatement.setDouble(1, operation.getNumber1());
            preparedStatement.setDouble(2, operation.getNumber2());
            preparedStatement.setDouble(3, operation.getResult());
            preparedStatement.setString(4, operation.getOperationNumber());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    @Override
    public List<Operation> findAll() {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "arinemiller22")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from \"Operations\"");
            List<Operation> operations = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                double num1 = resultSet.getDouble(2);
                double num2 = resultSet.getDouble(3);
                double result = resultSet.getDouble(4);
                String type = resultSet.getString(5);
                Operation operation = new Operation(id, num1, num2, result, type);
                operations.add(operation);
            }
            return operations;

        } catch (SQLException e) {

        }
        return new ArrayList<>();

    }

    public Optional<Operation> findById(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "arinemiller22")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from \"Operations\" where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int num1 = resultSet.getInt(2);
            int num2 = resultSet.getInt(3);
            int result = resultSet.getInt(4);
            String type = resultSet.getString(5);
            Operation operation = new Operation(id, num1, num2, result, type);
            return Optional.of(operation);
        } catch (SQLException e) {

        }
        return Optional.empty();
    }

    public void deleteById(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "arinemiller22")) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from operations where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
        }
    }


}
