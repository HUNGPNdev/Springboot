package t3h.springboot.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t3h.springboot.entitis.User;
import t3h.springboot.repository.UserRepository;
import t3h.springboot.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getALlUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        for (User u: this.getALlUser()) {
            if (id == u.getUserId()) {
                user = u;
            }
        }
        return user;
    }

    @Override
    public void editById(User user) {
        for (User u :this.getALlUser()) {
            if (user.getUserId() == u.getUserId()) {
                userRepository.save(user);
            }
        }
    }

    @Override
    public boolean authUser(String name, String pass) {
        boolean result=false;
        for (User u :this.getALlUser()) {
            if (name.equals(u.getUsername()) && pass.equals(u.getPassword())) {
                result =  true;
                break;
            }
        }
        return result;
    }

    @Override
    public void insert(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
