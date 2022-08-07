package org.example.service.rest.models.airPlane;

import org.example.dto.models.modif.AirPlaneDTOModif;
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
public class AirPlaneRestTemplateServiceImpl implements AirPlaneRestTemplateService {
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    @Value(value = "${server.data-base-app.url}")
    private String DATA_BASE_APP_URL;
    private final String PATH = "/air/plane/";

    @Override
    public List<AirPlaneDTOModif> readAll() {
        String uriVar = "read/all";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AirPlaneDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<AirPlaneDTOModif[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, AirPlaneDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public AirPlaneDTOModif readById(Long id) {
        String uriVar = "read/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AirPlaneDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<AirPlaneDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, AirPlaneDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<AirPlaneDTOModif> readAllByIds(List<Long> ids) {
        String uriVar = "read/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<AirPlaneDTOModif[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, AirPlaneDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public AirPlaneDTOModif create(AirPlaneDTOModif airPlaneDTOModif) {
        String uriVar = "create";
        HttpEntity<AirPlaneDTOModif> httpEntity = new HttpEntity<>(airPlaneDTOModif);
        ResponseEntity<AirPlaneDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, AirPlaneDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public AirPlaneDTOModif update(AirPlaneDTOModif airPlaneDTOModif) {
        String uriVar = "update";
        HttpEntity<AirPlaneDTOModif> httpEntity = new HttpEntity<>(airPlaneDTOModif);
        ResponseEntity<AirPlaneDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.PUT, httpEntity, AirPlaneDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public AirPlaneDTOModif deleteById(Long id) {
        String uriVar = "delete/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AirPlaneDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<AirPlaneDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, AirPlaneDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<AirPlaneDTOModif> deleteAllByIds(List<Long> ids) {
        String uriVar = "delete/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<AirPlaneDTOModif[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, AirPlaneDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
