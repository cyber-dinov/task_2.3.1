package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao{

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public User getById(Long id){
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(Long id){
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void update(User user, Long id){
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> getAllUsersQuery = entityManager.createQuery("FROM User", User.class);
        return getAllUsersQuery.getResultList();
    }
}
