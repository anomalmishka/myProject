package org.example.service.models.login;

import lombok.RequiredArgsConstructor;
import org.example.dao.LoginDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.model.Login;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final LoginDAO loginDAO;


    @Override
    public List<Login> readAll() {
        return loginDAO.findAll();
    }

    @Override
    public Login readById(Long id) {
        return loginDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<Login> readAllByIds(List<Long> ids) {
        return loginDAO.findAllById(ids);
    }

    @Override
    public Login create(Login login) {
        return loginDAO.save(login);
    }

    @Override
    public Login update(Login login) {
        return loginDAO.save(login);
    }

    @Override
    public Login deleteById(Long id) {
        Login deleteEntity = loginDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
        loginDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<Login> deleteAllByIds(List<Long> ids) {
        List<Login> loginList = readAllByIds(ids);
        loginDAO.deleteAllById(ids);
        return loginList;
    }

    @Override
    public Login findByUsername(String username) {
        System.out.println("findByUsername");
        return loginDAO.findByUsername(username);
    }
}
