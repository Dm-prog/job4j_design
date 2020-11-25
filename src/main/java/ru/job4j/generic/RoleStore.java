package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class RoleStore implements Store<User> {
    private final List<User> rol = new ArrayList<>();


    @Override
    public void add(User model) {
        for (User user : rol) {
            if (findById(user.getId()) == null) {
                rol.add(model);
            }
        }
    }

    @Override
    public boolean replace(String id, User model) {
        for (int i = 0; i < rol.size(); i++) {
            if (rol.get(i).getId().equals(id)) {
                rol.replaceAll((UnaryOperator<User>) model);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (int i = 0; i < rol.size(); i++) {
            if (rol.get(i).equals(id)) {
                rol.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public User findById(String id) {
        for (int i = 0; i < rol.size(); i++) {
            if (rol.get(i).equals(id)) {
                return rol.get(i);
            }
        }
        return null;
    }
}
