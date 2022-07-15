package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.service.api.BuisnessUserService;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BuisnessUserServiceImpl implements BuisnessUserService {

    private final UserServiceImpl userService;

    @Override
    public User createUserWithAll(User user) {
        return userService.create(user);
    }

    @Override
    public List<User> readAll() {
        return userService.readAll();
    }

    @Override
    public User readById(Long id) {
        return userService.readById(id);
    }

    @Override
    public List<User> readAllByIds(List<Long> ids) {
        return userService.readAllByIds(ids);
    }

    @Override
    public User deleteById(Long id) {
        return userService.deleteById(id);
    }

    @Override
    public List<User> deleteAllByIds(List<Long> ids) {
        return userService.deleteAllByIds(ids);
    }

    @Override
    public User updateUserWithAll(User user) {
        return userService.update(user);
    }

}
