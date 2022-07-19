package org.example.service;

import org.example.dto.modelsDTO.modif.AirPlaneDTOModif;
import org.example.model.filter.FilterObj;
import org.example.service.interfaces.RestTemplateService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    private final String URL = "http://localhost:8003/data-base-app/buisness/filter/air/plane/";

    @Override
    public AirPlaneDTOModif postAirPlaneDTOModif(AirPlaneDTOModif airPlaneDTOModif, String uriVar) {
        HttpEntity<AirPlaneDTOModif> request = new HttpEntity<>(airPlaneDTOModif);
        return restTemplate.postForObject(URL + uriVar, request, AirPlaneDTOModif.class);
    }

    @Override
    public AirPlaneDTOModif exchangeAirPlaneDTOModif(AirPlaneDTOModif airPlaneDTOModif, String uriVar, HttpMethod httpMethod) {
        ResponseEntity<AirPlaneDTOModif> responseEntity = restTemplate.exchange(URL + uriVar, httpMethod, new HttpEntity<>(airPlaneDTOModif), AirPlaneDTOModif.class);
        return responseEntity.getBody();
    }
    @Override
    public AirPlaneDTOModif exchangeAirPlaneDTOModif(String uriVar, Long id, HttpMethod httpMethod) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<AirPlaneDTOModif> httpEntity = new HttpEntity<>(headers);
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<AirPlaneDTOModif> responseEntity = restTemplate.exchange(URL + uriVar + id+"/", httpMethod, httpEntity, AirPlaneDTOModif.class);
        return responseEntity.getBody();
    }

    @Override
    public List<AirPlaneDTOModif> exchangeFilterObj(FilterObj filterObj, String uriVar, HttpMethod httpMethod) {
        ResponseEntity<AirPlaneDTOModif[]> responseEntity = restTemplate.exchange(URL + uriVar, httpMethod, new HttpEntity<>(filterObj), AirPlaneDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
