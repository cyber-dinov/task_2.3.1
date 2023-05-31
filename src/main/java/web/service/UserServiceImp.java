package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional(readOnly = true)
   @Override
   public User getById(Long id){
      return userDao.getById(id);
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }
   @Transactional
   @Override
   public void delete(Long id) {
      userDao.delete(id);
   }

   @Transactional
   @Override
   public void update(User user, Long id) {
      userDao.update(user, id);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getUserList() {
      return userDao.getUsers();
   }



}
