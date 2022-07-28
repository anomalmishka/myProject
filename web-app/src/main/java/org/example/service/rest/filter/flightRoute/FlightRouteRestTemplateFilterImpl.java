package org.example.service.rest.filter.flightRoute;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.FlightRouteDTOModif;
import org.example.mapper.FilterMapper;
import org.example.mapper.model.modif.FlightRouteMapperModif;
import org.example.model.Filter;
import org.example.model.database.FlightRoute;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FlightRouteRestTemplateFilterImpl implements FlightRouteRestTemplateFilter {
    private final FlightRouteMapperModif flightRouteMapperModif;
    private final FilterMapper filterMapper;

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    private final String URL = "http://localhost:8003/data-base-app/buisness/filter/flight/route/";

//    @Override
//    public AirPlaneModif postAirPlaneModif(AirPlaneModif airPlaneModif, String uriVar) {
//        HttpEntity<AirPlaneModif> request = new HttpEntity<>(airPlaneModif);
//        return restTemplate.postForObject(URL + uriVar, request, AirPlaneModif.class);
//    }
//
//    @Override
//    public AirPlaneModif exchangeAirPlaneModif(AirPlaneModif airPlaneModif, String uriVar, HttpMethod httpMethod) {
//        ResponseEntity<AirPlaneModif> responseEntity = restTemplate.exchange(URL + uriVar, httpMethod, new HttpEntity<>(airPlaneModif), AirPlaneModif.class);
//        return responseEntity.getBody();
//    }
//    @Override
//    public AirPlaneModif exchangeAirPlaneModif(String uriVar, Long id, HttpMethod httpMethod) {
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<AirPlaneModif> httpEntity = new HttpEntity<>(headers);
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        ResponseEntity<AirPlaneModif> responseEntity = restTemplate.exchange(URL + uriVar + id+"/", httpMethod, httpEntity, AirPlaneModif.class);
//        return responseEntity.getBody();
//    }

    @Override
    public List<FlightRoute> exchangeFilterObj(Filter filter, String uriVar, HttpMethod httpMethod) {
        ResponseEntity<FlightRouteDTOModif[]> responseEntity =
                restTemplate.exchange(URL + uriVar, httpMethod,
                        new HttpEntity<>(filterMapper.toDTO(filter)), FlightRouteDTOModif[].class);
        List<FlightRouteDTOModif> flightRouteDTOModifList =
                Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
        return flightRouteMapperModif.toModel(flightRouteDTOModifList);
    }
}