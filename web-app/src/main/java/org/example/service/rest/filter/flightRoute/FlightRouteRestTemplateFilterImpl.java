package org.example.service.rest.filter.flightRoute;

import org.example.dto.FilterDTO;
import org.example.dto.modelsDTO.modif2.FlightRouteDTOModif2;
import org.springframework.beans.factory.annotation.Value;
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
    @Value(value = "${server.data-base-app.url}")
    private String DATA_BASE_APP_URL;
    private final String PATH = "/buisness/filer/flight/route/";

    @Override
    public List<FlightRouteDTOModif2> exchangeFilterToFlightRoute(FilterDTO filterDTO, String uriVar) {
        String url = DATA_BASE_APP_URL + PATH + uriVar;
        System.out.println(url);
        ResponseEntity<FlightRouteDTOModif2[]> responseEntity =
                restTemplate.exchange(url, HttpMethod.POST,
                        new HttpEntity<>(filterDTO), FlightRouteDTOModif2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public List<FlightRouteDTOModif2> findAll() {
        String url = DATA_BASE_APP_URL + "/modif/flight/route/read/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<FlightRouteDTOModif2> httpEntity = new HttpEntity<>(headers);
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<FlightRouteDTOModif2[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, FlightRouteDTOModif2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
