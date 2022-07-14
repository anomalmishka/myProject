package org.example.service.api;
import org.example.model.User;
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

