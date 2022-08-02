package org.example.service.models.user;

import lombok.RequiredArgsConstructor;
import org.example.dao.UserDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;


    @Override
    public List<User> readAll() {
        return userDAO.findAll();
    }

    @Override
    public User readById(Long id) {
        return userDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<User> readAllByIds(List<Long> ids) {
        return userDAO.findAllById(ids);
    }

    @Override
    public User create(User user) {
        return userDAO.save(user);
    }

    @Override
    public User update(User user) {
        return userDAO.save(user);
    }

    @Override
    public User deleteById(Long id) {
        User deleteEntity = userDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
        userDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<User> deleteAllByIds(List<Long> ids) {
        List<User> userList = readAllByIds(ids);
        userDAO.deleteAllById(ids);
        return userList;
    }

    @Override
    public User findByUsername(String username) {
        System.out.println("findByUsername");
        return userDAO.findByUsername(username);
    }
}
