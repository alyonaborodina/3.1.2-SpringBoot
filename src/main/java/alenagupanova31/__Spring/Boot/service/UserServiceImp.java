package alenagupanova31.__Spring.Boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import alenagupanova31.__Spring.Boot.dao.UserDao;
import alenagupanova31.__Spring.Boot.models.User;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;


    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }


    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
}
