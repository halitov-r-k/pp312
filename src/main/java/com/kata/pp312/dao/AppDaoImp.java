package com.kata.pp312.dao;

import com.kata.pp312.modeles.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class AppDaoImp implements AppDao {

    @PersistenceContext
    private EntityManager entityManager;
    static private final Logger LOGGER = Logger.getLogger("AppDaoImpLogger");

    @Override
    public List<User> getUserList() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User userNew) {
        LOGGER.log(Level.INFO, "updateUser(), parameter userNew=" + userNew.toString());
        entityManager.merge(userNew);
    }

    @Override
    public void deleteUser(Integer id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}