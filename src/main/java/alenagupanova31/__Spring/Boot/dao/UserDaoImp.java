package alenagupanova31.__Spring.Boot.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import alenagupanova31.__Spring.Boot.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Transactional
    @Override
    public User findById(Integer id) {
        return entityManager.find(User.class, id);
    }
}

