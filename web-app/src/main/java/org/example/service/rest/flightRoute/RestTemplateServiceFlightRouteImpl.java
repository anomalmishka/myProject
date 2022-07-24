package org.example.service.rest.flightRoute;

import org.example.model.obj.database.modif.FlightRouteModif;
import org.example.model.obj.filter.FilterObj;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RestTemplateServiceFlightRouteImpl implements RestTemplateServiceFlightRoute {

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    private final String URL = "http://localhost:8003/data-base-app/buisness/filter/air/plane/";

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
    public List<FlightRouteModif> exchangeFilterObj(FilterObj filterObj, String uriVar, HttpMethod httpMethod) {
        ResponseEntity<FlightRouteModif[]> responseEntity = restTemplate.exchange(URL + uriVar, httpMethod, new HttpEntity<>(filterObj), FlightRouteModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
