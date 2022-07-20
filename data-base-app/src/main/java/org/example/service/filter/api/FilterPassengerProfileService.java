package org.example.service.filter.api;

import org.example.model.entity.PassengerProfile;

import java.util.List;

public interface FilterPassengerProfileService {

    List<PassengerProfile> findAllPassengerProfileWhereAirCompany(Long idAirCompany);

    List<PassengerProfile> findAllPassengerProfileWhereAirPlane(Long idAirPlane);
}

