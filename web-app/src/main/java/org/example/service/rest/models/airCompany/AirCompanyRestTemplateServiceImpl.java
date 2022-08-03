package org.example.service.rest.models.airCompany;

import org.example.dto.modelsDTO.AirCompanyDTO;
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
public class AirCompanyRestTemplateServiceImpl implements AirCompanyRestTemplateService {
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    @Value(value = "${server.data-base-app.url}")
    private String DATA_BASE_APP_URL;
    private final String PATH = "/air/company/";

    @Override
    public List<AirCompanyDTO> readAll() {
        String uriVar = "read/all";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AirCompanyDTO> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<AirCompanyDTO[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, AirCompanyDTO[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public AirCompanyDTO readById(Long id) {
        String uriVar = "read/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AirCompanyDTO> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<AirCompanyDTO> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, AirCompanyDTO.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<AirCompanyDTO> readAllByIds(List<Long> ids) {
        String uriVar = "read/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<AirCompanyDTO[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, AirCompanyDTO[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public AirCompanyDTO create(AirCompanyDTO airCompanyDTO) {
        String uriVar = "create";
        HttpEntity<AirCompanyDTO> httpEntity = new HttpEntity<>(airCompanyDTO);
        ResponseEntity<AirCompanyDTO> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, AirCompanyDTO.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public AirCompanyDTO update(AirCompanyDTO airCompanyDTO) {
        String uriVar = "update";
        HttpEntity<AirCompanyDTO> httpEntity = new HttpEntity<>(airCompanyDTO);
        ResponseEntity<AirCompanyDTO> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.PUT, httpEntity, AirCompanyDTO.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public AirCompanyDTO deleteById(Long id) {
        String uriVar = "delete/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AirCompanyDTO> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<AirCompanyDTO> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, AirCompanyDTO.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<AirCompanyDTO> deleteAllByIds(List<Long> ids) {
        String uriVar = "delete/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<AirCompanyDTO[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, AirCompanyDTO[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
