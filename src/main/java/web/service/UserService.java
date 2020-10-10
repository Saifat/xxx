package web.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;



public interface UserService {

    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(int id);
    public User getUserById(int id);
    public List<User> listUsers();
}
