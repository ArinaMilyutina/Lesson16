package console;

import console.util.ConsoleReader;
import console.util.ConsoleWriter;
import console.util.Reader;
import console.util.Writer;
import entity.Operation;
import entity.User;
import helpers.ConsoleHelpers;
import helpers.Helpers;
import service.CalculatorService;
import service.UserService;
import storage.FileStorage;


import java.util.List;
import java.util.Optional;


public class ConsoleApplication implements Application {

    public static ConsoleSession consoleSession;

    private final Writer write = new ConsoleWriter();
    private final Reader reader = new ConsoleReader();
    private final Helpers helpers = new ConsoleHelpers();
    private final CalculatorService calculator = new CalculatorService();
    private final FileStorage fileOperationStorage = new FileStorage();
    private final UserService userService = new UserService();
    private static final String USERNAME = "^[a-zA-Z]{4,8}$";
    private static final String PASSWORD = "^[0-9]{8}$";
    private static final String NAME = "^[A-Z][a-z]{1,20}$";


    public void run() {
        while (true) {
            fileOperationStorage.checkFile();
            if (consoleSession == null) {
                helpers.consoleMenuHelperUser();
                String s = reader.readString();
                switch (s) {
                    case "1":
                        write.writer("Enter name");
                        String name = reader.readString();
                        if (!name.matches(NAME)) {
                            write.writerError("Incorrect name!!!");
                            continue;
                        }
                        write.writer("Enter username(Latin letters from 4-8)");
                        String username = reader.readString();
                        if (!username.matches(USERNAME)) {
                            write.writerError("Incorrect username!!!");
                            continue;
                        }
                        write.writer("Enter password(Only 8 digits from 0-9)");
                        String pass = reader.readString();
                        if (!pass.matches(PASSWORD)) {
                            write.writerError("Incorrect password!!!");
                            continue;
                        }
                        User user = new User(username, pass, name);
                        userService.create(user);
                        continue;
                    case "2":
                        write.writer("Enter username");
                        String username2 = reader.readString();
                        write.writer("Enter password");
                        String pass2 = reader.readString();
                        Optional<User> byUsername = userService.findByUsername(username2);
                        if (byUsername.isPresent()) {
                            User user1 = byUsername.get();
                            if (user1.getPassword().equals(pass2)) {
                                consoleSession = new ConsoleSession(user1);
                                continue;
                            } else {
                                write.writer("Wrong password!");
                                continue;
                            }
                        } else {
                            write.writer("User not found!");
                            continue;
                        }
                    case "3":
                        return;
                }

            } else {
                write.writer(consoleSession.getCurrentUser().getName() + ", enter the number operation:");
                helpers.consoleMenuHelper();
                switch (reader.readString()) {
                    case "1":
                        write.writer("Enter number 1");
                        double num1 = reader.readDouble();
                        write.writer("Enter number 2");
                        double num2 = reader.readDouble();
                        helpers.consoleMenuHelperOperation();
                        String operation = reader.readString();
                        Operation operations = new Operation(num1, num2, operation);
                        Optional<Operation> result = calculator.calculate(operations);
                        write.writer("Result = " + result.toString());
                        continue;
                    case "2":
                        fileOperationStorage.readFromFile();
                        continue;
                    case "3": {
                        List<Operation> operations1 = calculator.showOperation();
                        operations1.forEach((o) -> write.writer(o.toString()));
                        continue;
                    }
                    case "4":
                        List<User> users = userService.showUsers();
                        users.forEach((u) -> write.writer(u.toString()));
                        continue;

                    case "5":
                        consoleSession = null;
                        continue;
                    case "6":
                        return;
                }
            }
        }
    }
}
