package org.example.service.models.airPlane;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.service.rest.models.airPlane.AirPlaneRestTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AirPlaneServiceImpl implements AirPlaneService {

    private final AirPlaneRestTemplateService airPlaneRestTemplateService;

    @Override
    public AirPlaneDTOModif create(AirPlaneDTOModif airPlaneDTOModif) {
        return airPlaneRestTemplateService.create(airPlaneDTOModif);
    }

    @Override
    public List<AirPlaneDTOModif> readAll() {
        return airPlaneRestTemplateService.readAll();
    }

    @Override
    public AirPlaneDTOModif readById(Long id) {
        return airPlaneRestTemplateService.readById(id);
    }

    @Override
    public List<AirPlaneDTOModif> readAllByIds(List<Long> ids) {
        return airPlaneRestTemplateService.readAllByIds(ids);
    }

    @Override
    public AirPlaneDTOModif deleteById(Long id) {
        return airPlaneRestTemplateService.deleteById(id);
    }

    @Override
    public List<AirPlaneDTOModif> deleteAllByIds(List<Long> ids) {
        return airPlaneRestTemplateService.deleteAllByIds(ids);
    }

    @Override
    public AirPlaneDTOModif update(AirPlaneDTOModif airPlaneDTOModif) {
        return airPlaneRestTemplateService.update(airPlaneDTOModif);
    }
}
