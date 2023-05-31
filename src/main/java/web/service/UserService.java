package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void delete(Long id);

    void update(User user, Long id);

    User getById(Long id);

    List<User> getUserList();
}
