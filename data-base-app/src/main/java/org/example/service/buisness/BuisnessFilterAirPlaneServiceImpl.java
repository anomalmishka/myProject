package org.example.service.buisness;

import lombok.RequiredArgsConstructor;
import org.example.dao.custom.AirPlaneCustomDAOImpl;
import org.example.dto.api.FilterAirPlaneObject;
import org.example.model.AirPlane;
import org.example.service.api.buisness.BuisnessFilterAirPlaneService;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class BuisnessFilterAirPlaneServiceImpl implements BuisnessFilterAirPlaneService {

    private final AirPlaneCustomDAOImpl airPlaneCustomDAOImpl;

    @Override
    public List<AirPlane> findAirPlaneWhereRouteStartAndRouteEnd(FilterAirPlaneObject filterAirPlaneObject) {
        return airPlaneCustomDAOImpl.findAirPlaneWhereRouteStartAndRouteEnd(filterAirPlaneObject);
    }

    @Override
    public List<AirPlane> findAirPlaneWhereDateStartAndDateEnd(FilterAirPlaneObject filterAirPlaneObject) {
        return airPlaneCustomDAOImpl.findAirPlaneWhereDateStartAndDateEnd(filterAirPlaneObject);
    }

    @Override
    public List<AirPlane> findAirPlaneWherePriceStartAndPriceEnd(FilterAirPlaneObject filterAirPlaneObject) {
        return airPlaneCustomDAOImpl.findAirPlaneWherePriceStartAndPriceEnd(filterAirPlaneObject);
    }

    @Override
    public List<AirPlane> findAirPlaneWhereRouteSEAndDateSE(FilterAirPlaneObject filterAirPlaneObject) {
        return airPlaneCustomDAOImpl.findAirPlaneWhereRouteSEAndDateSE(filterAirPlaneObject);
    }

    @Override
    public List<AirPlane> findAirPlaneWhereRouteSEAndPriceSE(FilterAirPlaneObject filterAirPlaneObject) {
        return airPlaneCustomDAOImpl.findAirPlaneWhereRouteSEAndPriceSE(filterAirPlaneObject);
    }

    @Override
    public List<AirPlane> findAirPlaneWhereDateSEAndPriceSE(FilterAirPlaneObject filterAirPlaneObject) {
        return airPlaneCustomDAOImpl.findAirPlaneWhereDateSEAndPriceSE(filterAirPlaneObject);
    }

    @Override
    public List<AirPlane> findAirPlaneWhereRouteSEAndDateSEAndPriceSE(FilterAirPlaneObject filterAirPlaneObject) {
        return airPlaneCustomDAOImpl.findAirPlaneWhereRouteSEAndDateSEAndPriceSE(filterAirPlaneObject);
    }
}
