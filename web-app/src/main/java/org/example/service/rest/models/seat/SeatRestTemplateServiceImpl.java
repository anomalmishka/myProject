package org.example.service.rest.models.seat;

import org.example.dto.models.SeatDTO;
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
public class SeatRestTemplateServiceImpl implements SeatRestTemplateService {
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    @Value(value = "${server.data-base-app.url}")
    private String DATA_BASE_APP_URL;
    private final String PATH = "/seat/";

    @Override
    public List<SeatDTO> readAll() {
        String uriVar = "read/all";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SeatDTO> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<SeatDTO[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, SeatDTO[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public SeatDTO readById(Long id) {
        String uriVar = "read/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SeatDTO> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<SeatDTO> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, SeatDTO.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<SeatDTO> readAllByIds(List<Long> ids) {
        String uriVar = "read/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<SeatDTO[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, SeatDTO[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public SeatDTO create(SeatDTO seatDTO) {
        String uriVar = "create";
        HttpEntity<SeatDTO> httpEntity = new HttpEntity<>(seatDTO);
        ResponseEntity<SeatDTO> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, SeatDTO.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public SeatDTO update(SeatDTO flightRouteDTOModif) {
        String uriVar = "update";
        HttpEntity<SeatDTO> httpEntity = new HttpEntity<>(flightRouteDTOModif);
        ResponseEntity<SeatDTO> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.PUT, httpEntity, SeatDTO.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public SeatDTO deleteById(Long id) {
        String uriVar = "delete/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SeatDTO> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<SeatDTO> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, SeatDTO.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<SeatDTO> deleteAllByIds(List<Long> ids) {
        String uriVar = "delete/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<SeatDTO[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, SeatDTO[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
