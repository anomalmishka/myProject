package org.example.service.rest.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.AirCompanyDTO;
import org.example.dto.models.modif.AirCompanyDTOModif;
import org.example.mapper.model.modif.AirCompanyMapperModif;
import org.example.model.database.AirCompany;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AirCompanyRestTemplateServiceModifImpl implements AirCompanyRestTemplateServiceModif {
    private final AirCompanyMapperModif airCompanyMapperModif;

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    private final String URL = "http://localhost:8003/data-base-app/modif/air/company/";

    @Override
    public List<AirCompany> readAll() {
        String uriVar = "read/all";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AirCompanyDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<AirCompanyDTOModif[]> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.GET, httpEntity, AirCompanyDTOModif[].class);
        return airCompanyMapperModif.toModel(Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList()));
    }

    @Override
    public AirCompany readById(Long id) {
        String uriVar = "read/"+id+"/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AirCompanyDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<AirCompanyDTOModif> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.GET, httpEntity, AirCompanyDTOModif.class);
        return airCompanyMapperModif.toModel(Objects.requireNonNull(responseEntity.getBody()));
    }

    @Override
    public List<AirCompany> readAllByIds(List<Long> ids) {
        String uriVar = "read/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<AirCompanyDTOModif[]> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.POST, httpEntity, AirCompanyDTOModif[].class);
        return airCompanyMapperModif.toModel(Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList()));
    }

    @Override
    public AirCompany create(AirCompany airCompany) {
        String uriVar = "create";
        HttpEntity<AirCompanyDTOModif> httpEntity = new HttpEntity<>(airCompanyMapperModif.toDTO(airCompany));
        ResponseEntity<AirCompanyDTOModif> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.POST, httpEntity, AirCompanyDTOModif.class);
        return airCompanyMapperModif.toModel(Objects.requireNonNull(responseEntity.getBody()));
    }

    @Override
    public AirCompany update(AirCompany airCompany) {
        String uriVar = "update";
        HttpEntity<AirCompanyDTOModif> httpEntity = new HttpEntity<>(airCompanyMapperModif.toDTO(airCompany));
        ResponseEntity<AirCompanyDTOModif> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.PUT, httpEntity, AirCompanyDTOModif.class);
        return airCompanyMapperModif.toModel(Objects.requireNonNull(responseEntity.getBody()));
    }
}
