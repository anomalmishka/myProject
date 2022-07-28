package org.example.service.filter;

import lombok.RequiredArgsConstructor;
import org.example.dao.custom.airCompany.AirCompanyCustomDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.AirCompany;
import org.example.model.filter.FilterObj;
import org.example.service.filter.api.AirCompanyLadderService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AirCompanyLadderServiceImpl implements AirCompanyLadderService {

    private final AirCompanyCustomDAO airCompanyCustomDAO;

    @Override
    public List<AirCompany> findAirCompanyWhereRouteStartAndRouteEnd(FilterObj filterObj) {
        if (filterObj.getRouteStart() != null) {
            System.out.println("serv impl"+filterObj);
            return airCompanyCustomDAO.findAirCompanyWhereRouteStartAndRouteEnd(filterObj);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }

    @Override
    public List<AirCompany> findAirCompanyWhereDateStartAndDateEnd(FilterObj filterObj) {
        if (filterObj.getDateStart() != null) {
            return airCompanyCustomDAO.findAirCompanyWhereDateStartAndDateEnd(filterObj);
        } else {
            throw new ErrorInvalidData("DateStart must not be null");
        }
    }

    @Override
    public List<AirCompany> findAirCompanyWhereRouteSEOneWaypoint(FilterObj filterObj) {
        if (filterObj.getRouteStart() != null) {
            return airCompanyCustomDAO.findAirCompanyWhereRouteSEOneWaypoint(filterObj);
        } else {
            throw new ErrorInvalidData("RouteStart must not be null");
        }
    }
}
