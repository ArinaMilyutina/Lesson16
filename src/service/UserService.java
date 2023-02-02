package service;

import entity.User;
import storage.FileStorage;
import storage.InMemoryUserStorage;

import java.util.List;
import java.util.Optional;

public class UserService {

    private final InMemoryUserStorage storage = new InMemoryUserStorage();
    private final FileStorage fileOperationStorage = new FileStorage();
    private final InMemoryUserStorage userStorage = new InMemoryUserStorage();

    public void create(User user) {
        storage.saveUser(user);
        fileOperationStorage.saveUser(user);
    }

    public List<User> showUsers() {
        return userStorage.find();
    }

    public Optional<User> findByUsername(String username) {
        return storage.getByUsername(username);
    }

}
