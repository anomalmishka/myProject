package org.example.service.api.buisness;

import org.example.model.User;

import java.util.List;

public interface BuisnessFilterUserService {

    List<User> findAllUserWhereAirCompany(Long idAirCompany);

    List<User> findAllUserWhereAirPlane(Long idAirPlane);
}

