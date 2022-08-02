package org.example.service.filter.filterSelect;

import org.example.dto.FilterObj;
import org.example.dto.modelsDTO.modif2.FlightRouteDTOModif2;

import java.util.List;

public interface FilterSelectService {

    List<FlightRouteDTOModif2> filterSelect(FilterObj filterObj);
}
