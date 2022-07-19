package org.example.service.models;


import lombok.RequiredArgsConstructor;
import org.example.dao.models.UserDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.User;
import org.example.service.models.api.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserDAO userDAO;


    @Override
    public User create(User user) {
        if (user.getName() != null) {
            return userDAO.save(user);
        } else {
            throw new ErrorInvalidData("Name must not be null");
        }
    }

    @Override
    public List<User> readAll() {
        return StreamSupport
                .stream(userDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public User readById(Long id) {
        return userDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<User> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(userDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public User deleteById(Long id) {
        User deleteEntity = readById(id);
        userDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<User> deleteAllByIds(List<Long> ids) {
        List<User> deleteEntities = readAllByIds(ids);
        userDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public User update(User user) {
        if (user.getName() != null) {
            return userDAO.save(user);
        } else {
            throw new ErrorInvalidData("Name must not be null");
        }
    }
}
