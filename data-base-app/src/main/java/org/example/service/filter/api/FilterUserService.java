package org.example.service.filter.api;

import org.example.model.entity.User;

import java.util.List;

public interface FilterUserService {

    List<User> findAllUserWhereAirCompany(Long idAirCompany);

    List<User> findAllUserWhereAirPlane(Long idAirPlane);
}

