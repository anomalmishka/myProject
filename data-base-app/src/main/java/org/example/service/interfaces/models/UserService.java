package org.example.service.interfaces.models;
import org.example.model.entity.User;
import java.util.List;

public interface UserService {

    User create(User user);

    List<User> readAll();

    User readById(Long id);

    List<User> readAllByIds(List<Long> ids);

    User deleteById(Long id);

    List<User> deleteAllByIds(List<Long> ids);

    User update(User user);
}

