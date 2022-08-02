package org.example.service.models.user;

import org.example.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    List<User> readAll();

    User readById(Long id);

    List<User> readAllByIds(List<Long> ids);

    User create(User userProfileDTO);

    User update(User userProfileDTO);

    User deleteById(Long id);

    List<User> deleteAllByIds(List<Long> ids);

    User findByUsername(String username);
}
