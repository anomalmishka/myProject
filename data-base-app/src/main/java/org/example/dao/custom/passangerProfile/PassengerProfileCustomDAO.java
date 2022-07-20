package org.example.dao.custom.passangerProfile;

import org.example.model.entity.PassengerProfile;

import java.util.List;

public interface PassengerProfileCustomDAO {
    List<PassengerProfile> findAllPassengerProfileWhereAirCompany(Long idAirCompany);
    List<PassengerProfile> findAllPassengerProfileWhereAirPlane(Long idAirPlane);
}
