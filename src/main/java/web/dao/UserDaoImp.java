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
    public void add(User user){

        try {
            entityManager.persist(user);
            entityManager.flush();
        }
        catch (Exception ex){
            entityManager.getTransaction().rollback();
            System.out.println("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public User getById(Long id){

        try {
            return entityManager.find(User.class, id);
        }
        catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new IllegalArgumentException("getUsers transaction exception");
        }

    }

    @Override
    public void delete(Long id){
        try {
            entityManager.remove(entityManager.find(User.class, id));
        }
        catch (Exception ex) {
            entityManager.getTransaction().rollback();
            System.out.println("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public void update(User user, Long id){
        try{
            User user1 = entityManager.find(User.class, id);
            entityManager.merge(user1);
            entityManager.remove(user1);
            entityManager.merge(user);
            entityManager.flush();

        }
        catch (Exception ex) {
            entityManager.getTransaction().rollback();
            System.out.println("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public List<User> getUsers() {
        try {
            TypedQuery<User> getAllUsersQuery = entityManager.createQuery("FROM User", User.class);
            return getAllUsersQuery.getResultList();
        }
        catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new IllegalArgumentException("getUsers transaction exception");
        }

    }
}
