package org.example.service.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.AirCompanyDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.AirCompany;
import org.example.model.entity.AirPlane;
import org.example.model.entity.FlightRoute;
import org.example.service.api.AirPlaneService;
import org.example.service.api.FlightRouteService;
import org.example.service.models.modif.api.AirCompanyServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AirCompanyServiceImplModif implements AirCompanyServiceModif {

    private final AirCompanyDAO airCompanyDAO;
    private final AirPlaneService airPlaneService;
    private final FlightRouteService flightRouteService;

    @Override
    public AirCompany update(AirCompany airCompany) {
        if (airCompany.getNameCompany() != null) {
            List<AirPlane> airPlaneList = airCompany.getAirPlaneList();
            List<Long> airPlaneIdList = airPlaneList.stream().map(AirPlane::getId).collect(Collectors.toList());
            List<AirPlane> airPlaneFindList = airPlaneService.readAllByIds(airPlaneIdList);
            List<FlightRoute> flightRouteList = airCompany.getFlightRouteList();
            List<Long> flightRouteIdList = flightRouteList.stream().map(FlightRoute::getId).collect(Collectors.toList());
            List<FlightRoute> flightRouteFindList = flightRouteService.readAllByIds(flightRouteIdList);
            airCompany.setAirPlaneList(airPlaneFindList);
            airCompany.setFlightRouteList(flightRouteFindList);
            return airCompanyDAO.save(airCompany);
        } else {
            throw new ErrorInvalidData("NameCompany must not be null");
        }
    }
}
