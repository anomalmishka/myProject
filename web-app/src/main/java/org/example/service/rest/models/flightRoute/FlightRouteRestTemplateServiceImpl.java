package org.example.service.rest.models.flightRoute;

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
public class FlightRouteRestTemplateServiceImpl implements FlightRouteRestTemplateService {
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    @Value(value = "${server.data-base-app.url}")
    private String DATA_BASE_APP_URL;
    private final String PATH = "/modif/flight/route/";

    @Override
    public List<FlightRouteDTOModif> readAll() {
        String uriVar = "read/all";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FlightRouteDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<FlightRouteDTOModif[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, FlightRouteDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public FlightRouteDTOModif readById(Long id) {
        String uriVar = "read/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FlightRouteDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<FlightRouteDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, FlightRouteDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<FlightRouteDTOModif> readAllByIds(List<Long> ids) {
        String uriVar = "read/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<FlightRouteDTOModif[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, FlightRouteDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public FlightRouteDTOModif create(FlightRouteDTOModif flightRouteDTOModif) {
        String uriVar = "create";
        HttpEntity<FlightRouteDTOModif> httpEntity = new HttpEntity<>(flightRouteDTOModif);
        ResponseEntity<FlightRouteDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, FlightRouteDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public FlightRouteDTOModif update(FlightRouteDTOModif flightRouteDTOModif) {
        String uriVar = "update";
        HttpEntity<FlightRouteDTOModif> httpEntity = new HttpEntity<>(flightRouteDTOModif);
        ResponseEntity<FlightRouteDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.PUT, httpEntity, FlightRouteDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public FlightRouteDTOModif deleteById(Long id) {
        String uriVar = "delete/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FlightRouteDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<FlightRouteDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, FlightRouteDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<FlightRouteDTOModif> deleteAllByIds(List<Long> ids) {
        String uriVar = "delete/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<FlightRouteDTOModif[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, FlightRouteDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
