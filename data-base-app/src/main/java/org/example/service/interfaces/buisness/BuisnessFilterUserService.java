package org.example.service.interfaces.buisness;

import org.example.model.entity.User;

import java.util.List;

public interface BuisnessFilterUserService {

    List<User> findAllUserWhereAirCompany(Long idAirCompany);

    List<User> findAllUserWhereAirPlane(Long idAirPlane);
}

