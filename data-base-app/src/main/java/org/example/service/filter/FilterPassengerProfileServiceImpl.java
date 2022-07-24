package org.example.service.filter;

import lombok.RequiredArgsConstructor;
import org.example.dao.custom.passangerProfile.PassengerProfileCustomDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.PassengerProfile;
import org.example.service.filter.api.FilterPassengerProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilterPassengerProfileServiceImpl implements FilterPassengerProfileService {

    private final PassengerProfileCustomDAO passengerProfileCustomDAO;

    @Override
    public List<PassengerProfile> findAllPassengerProfileWhereAirCompany(Long idAirCompany) {
        if (idAirCompany != null) {
            return passengerProfileCustomDAO.findAllPassengerProfileWhereAirCompany(idAirCompany);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }

    @Override
    public List<PassengerProfile> findAllPassengerProfileWhereAirPlane(Long idAirPlane) {
        if (idAirPlane != null) {
        return passengerProfileCustomDAO.findAllPassengerProfileWhereAirPlane(idAirPlane);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }

}
