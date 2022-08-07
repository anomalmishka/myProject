package org.example.service.rest.filter.seat;

import org.example.dto.models.AirCompanyDTO;
import org.example.dto.models.SeatDTO;
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
public class SeatRestTemplateFilterImpl implements SeatRestTemplateFilter {
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    @Value(value = "${server.data-base-app.url}")
    private String DATA_BASE_APP_URL;

    @Override
    public List<SeatDTO> findSeatWhereAirPlaneId(Long idAirPlane) {
        String url = DATA_BASE_APP_URL + "/buisness/filter/seat/where/air/plane/" + idAirPlane + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SeatDTO> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<SeatDTO[]> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET,
                        httpEntity, SeatDTO[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
