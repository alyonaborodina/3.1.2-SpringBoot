package alenagupanova31.__Spring.Boot.service;

import alenagupanova31.__Spring.Boot.models.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(User user);
    void delete(User user);
    List<User> findAll();
    User findById(Integer id);
}
