package org.example.service.rest.models.passengerProfile;

import org.example.dto.models.modif.PassengerProfileDTOModif;
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
public class PassengerProfileRestTemlateServiceImpl implements PassengerProfileRestTemlateService {
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    @Value(value = "${server.data-base-app.url}")
    private String DATA_BASE_APP_URL;
    private final String PATH = "/modif/passenger/profile/";

    @Override
    public List<PassengerProfileDTOModif> readAll() {
        String uriVar = "read/all";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PassengerProfileDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<PassengerProfileDTOModif[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, PassengerProfileDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public PassengerProfileDTOModif readById(Long id) {
        String uriVar = "read/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PassengerProfileDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<PassengerProfileDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, PassengerProfileDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<PassengerProfileDTOModif> readAllByIds(List<Long> ids) {
        String uriVar = "read/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<PassengerProfileDTOModif[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, PassengerProfileDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public PassengerProfileDTOModif create(PassengerProfileDTOModif passengerProfileDTOModif) {
        String uriVar = "create";
        HttpEntity<PassengerProfileDTOModif> httpEntity = new HttpEntity<>(passengerProfileDTOModif);
        ResponseEntity<PassengerProfileDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, PassengerProfileDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public PassengerProfileDTOModif update(PassengerProfileDTOModif passengerProfileDTOModif) {
        String uriVar = "update";
        HttpEntity<PassengerProfileDTOModif> httpEntity = new HttpEntity<>(passengerProfileDTOModif);
        ResponseEntity<PassengerProfileDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.PUT, httpEntity, PassengerProfileDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public PassengerProfileDTOModif deleteById(Long id) {
        String uriVar = "delete/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PassengerProfileDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<PassengerProfileDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, PassengerProfileDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<PassengerProfileDTOModif> deleteAllByIds(List<Long> ids) {
        String uriVar = "delete/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<PassengerProfileDTOModif[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, PassengerProfileDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
