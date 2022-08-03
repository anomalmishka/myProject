package org.example.service.rest.models.flightRoute;

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
public class FlightRouteRestTemplateServiceImpl implements FlightRouteRestTemplateService {
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    @Value(value = "${server.data-base-app.url}")
    private String DATA_BASE_APP_URL;
    private final String PATH = "/modif/flight/route/";

    @Override
    public List<FlightRouteDTOModif2> readAll() {
        String uriVar = "read/all";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FlightRouteDTOModif2> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<FlightRouteDTOModif2[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, FlightRouteDTOModif2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public FlightRouteDTOModif2 readById(Long id) {
        String uriVar = "read/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FlightRouteDTOModif2> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<FlightRouteDTOModif2> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, FlightRouteDTOModif2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<FlightRouteDTOModif2> readAllByIds(List<Long> ids) {
        String uriVar = "read/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<FlightRouteDTOModif2[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, FlightRouteDTOModif2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public FlightRouteDTOModif2 create(FlightRouteDTOModif2 airCompanyDTO) {
        String uriVar = "create";
        HttpEntity<FlightRouteDTOModif2> httpEntity = new HttpEntity<>(airCompanyDTO);
        ResponseEntity<FlightRouteDTOModif2> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, FlightRouteDTOModif2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public FlightRouteDTOModif2 update(FlightRouteDTOModif2 airCompanyDTO) {
        String uriVar = "update";
        HttpEntity<FlightRouteDTOModif2> httpEntity = new HttpEntity<>(airCompanyDTO);
        ResponseEntity<FlightRouteDTOModif2> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.PUT, httpEntity, FlightRouteDTOModif2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public FlightRouteDTOModif2 deleteById(Long id) {
        String uriVar = "delete/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FlightRouteDTOModif2> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<FlightRouteDTOModif2> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, FlightRouteDTOModif2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<FlightRouteDTOModif2> deleteAllByIds(List<Long> ids) {
        String uriVar = "delete/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<FlightRouteDTOModif2[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, FlightRouteDTOModif2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
