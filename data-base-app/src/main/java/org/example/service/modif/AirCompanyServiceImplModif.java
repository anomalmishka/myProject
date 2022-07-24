package org.example.service.modif;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.AirCompanyDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.AirCompany;
import org.example.model.entity.AirPlane;
import org.example.service.models.api.AirPlaneService;
import org.example.service.modif.api.AirCompanyServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AirCompanyServiceImplModif implements AirCompanyServiceModif {

    private final AirCompanyDAO airCompanyDAO;
    private final AirPlaneService airPlaneService;

    @Override
    public AirCompany create(AirCompany airCompany) {
        return airCompanyDAO.save(setForgetValueOnId(airCompany));
    }

    @Override
    public AirCompany update(AirCompany airCompany) {
        return airCompanyDAO.save(setForgetValueOnId(airCompany));
    }

    private AirCompany setForgetValueOnId(AirCompany airCompany) {
        if (airCompany.getNameCompany() != null) {
            List<AirPlane> airPlaneList = airCompany.getAirPlaneList();
            List<Long> airPlaneIdList = airPlaneList.stream().map(AirPlane::getId).collect(Collectors.toList());
            List<AirPlane> airPlaneFindList = airPlaneService.readAllByIds(airPlaneIdList);
            airCompany.setAirPlaneList(airPlaneFindList);
            return airCompany;
        } else {
            throw new ErrorInvalidData("NameCompany must not be null");
        }
    }
}
