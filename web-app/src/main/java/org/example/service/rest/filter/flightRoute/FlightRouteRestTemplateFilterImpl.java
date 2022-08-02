package org.example.service.rest.filter.flightRoute;

import org.example.dto.FilterDTO;
import org.example.dto.modelsDTO.modif2.FlightRouteDTOModif2;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FlightRouteRestTemplateFilterImpl implements FlightRouteRestTemplateFilter {
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    private final String URL = "http://localhost:8003/data-base-app/buisness/filter/flight/route/";

    @Override
    public List<FlightRouteDTOModif2> exchangeFilterToFlightRoute(FilterDTO filterDTO, String uriVar) {
        ResponseEntity<FlightRouteDTOModif2[]> responseEntity =
                restTemplate.exchange(URL + uriVar, HttpMethod.POST,
                        new HttpEntity<>(filterDTO), FlightRouteDTOModif2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public List<FlightRouteDTOModif2> findAll() {
        String url = "http://localhost:8003/data-base-app/modif/flight/route/read/all";
                HttpHeaders headers = new HttpHeaders();
        HttpEntity<FlightRouteDTOModif2> httpEntity = new HttpEntity<>(headers);
        headers.setContentType(MediaType.APPLICATION_JSON);
       ResponseEntity<FlightRouteDTOModif2[]>  responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, FlightRouteDTOModif2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
