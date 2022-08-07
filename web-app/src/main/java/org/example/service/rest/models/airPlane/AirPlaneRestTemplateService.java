package org.example.service.rest.models.airPlane;

import org.example.dto.models.modif.AirPlaneDTOModif;

import java.util.List;

public interface AirPlaneRestTemplateService {
    List<AirPlaneDTOModif> readAll();

    AirPlaneDTOModif readById(Long id);

    List<AirPlaneDTOModif> readAllByIds(List<Long> ids);

    AirPlaneDTOModif create(AirPlaneDTOModif airPlaneDTOModif);

    AirPlaneDTOModif update(AirPlaneDTOModif airPlaneDTOModif);

    AirPlaneDTOModif deleteById(Long id);

    List<AirPlaneDTOModif> deleteAllByIds(List<Long> ids);
}
