package org.example.service.models.airPlane;

import org.example.dto.models.modif.AirPlaneDTOModif;

import java.util.List;

public interface AirPlaneService {
    AirPlaneDTOModif create(AirPlaneDTOModif airPlaneDTOModif);

    List<AirPlaneDTOModif> readAll();

    AirPlaneDTOModif readById(Long id);

    List<AirPlaneDTOModif> readAllByIds(List<Long> ids);

    AirPlaneDTOModif deleteById(Long id);

    List<AirPlaneDTOModif> deleteAllByIds(List<Long> ids);

    AirPlaneDTOModif update(AirPlaneDTOModif airPlaneDTOModif);
}
