package org.example.service.interfaces;

import org.example.dto.modelsDTO.modif.AirPlaneDTOModif;
import org.example.model.filter.FilterObj;

import java.util.List;

public interface WebAppService {

    List<AirPlaneDTOModif> findRoute(FilterObj filterObj);
}
