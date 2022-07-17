package org.example.dao.custom.user;

import org.example.model.entity.User;

import java.util.List;

public interface UserCustomDAO {
    List<User> findAllUserWhereAirCompany(Long idAirCompany);
    List<User> findAllUserWhereAirPlane(Long idAirPlane);
}
