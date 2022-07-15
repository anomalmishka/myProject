package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.FilterDAO;
import org.example.dto.api.FilterObject;
import org.example.model.AirPlane;
import org.example.service.api.BuisnessFilterService;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class BuisnessFilterServiceImpl implements BuisnessFilterService {

    private final FilterDAO filterDAO;

    @Override
    public List<AirPlane> findAirPlaneWhereRouteStartAndRouteEnd(FilterObject filterObject) {
        return filterDAO.findAirPlaneWhereRouteStartAndRouteEnd(filterObject);
    }

    @Override
    public List<AirPlane> findAirPlaneWhereDateStartAndDateEnd(FilterObject filterObject) {
        return filterDAO.findAirPlaneWhereDateStartAndDateEnd(filterObject);
    }

    @Override
    public List<AirPlane> findAirPlaneWherePriceStartAndPriceEnd(FilterObject filterObject) {
        return filterDAO.findAirPlaneWherePriceStartAndPriceEnd(filterObject);
    }
}
