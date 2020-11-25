package ru.job4j.generic;

public class UserStore implements Store<User> {

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        if (store.delete(id)) {
            return true;
        }
        return false;
    }

    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}
