package t3h.springboot.service;

import t3h.springboot.entitis.User;

import java.util.List;

public interface UserService {
    List<User> getALlUser();
    User getUserById(int id);
    void editById(User user);
    boolean authUser(String name, String pass);
    void insert(User user);
    void delete(int id);
}
