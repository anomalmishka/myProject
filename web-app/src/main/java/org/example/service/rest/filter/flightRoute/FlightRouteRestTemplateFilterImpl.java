package org.example.service.rest.filter.flightRoute;

import org.example.dto.filter.FilterDTO;
import org.example.dto.models.modif.FlightRouteDTOModif;
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

    @Override
    public List<FlightRouteDTOModif> exchangeFilterToFlightRoute(FilterDTO filterDTO, String uriVar) {
        String url = DATA_BASE_APP_URL + "/buisness/filter/flight/route/" + uriVar;
        ResponseEntity<FlightRouteDTOModif[]> responseEntity =
                restTemplate.exchange(url, HttpMethod.POST,
                        new HttpEntity<>(filterDTO), FlightRouteDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
    @Override
    public List<FlightRouteDTOModif> findById(Long id) {
        String url = DATA_BASE_APP_URL + "/buisness/filter/flight/route/find/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FlightRouteDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<FlightRouteDTOModif[]> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET,
                        httpEntity, FlightRouteDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
