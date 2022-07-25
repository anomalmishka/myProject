package org.example.service.rest.models.airCompany;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.AirCompanyDTO;
import org.example.mapper.model.AirCompanyMapper;
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
public class AirCompanyRestTemplateServiceImpl implements AirCompanyRestTemplateService {
    private final AirCompanyMapper airCompanyMapper;

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    private final String URL = "http://localhost:8003/data-base-app/air/company/";

    @Override
    public AirCompany create(AirCompany airCompany) {
        String uriVar = "create";
        HttpEntity<AirCompanyDTO> httpEntity = new HttpEntity<>(airCompanyMapper.toDTO(airCompany));
        ResponseEntity<AirCompanyDTO> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.POST, httpEntity, AirCompanyDTO.class);
        return airCompanyMapper.toModel(Objects.requireNonNull(responseEntity.getBody()));
    }

    @Override
    public List<AirCompany> readAll() {
        String uriVar = "read/all";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AirCompanyDTO> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<AirCompanyDTO[]> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.GET, httpEntity, AirCompanyDTO[].class);
        return airCompanyMapper.toModel(Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList()));
    }

    @Override
    public AirCompany readById(Long id) {
        String uriVar = "read/"+id+"/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AirCompanyDTO> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<AirCompanyDTO> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.GET, httpEntity, AirCompanyDTO.class);
        return airCompanyMapper.toModel(Objects.requireNonNull(responseEntity.getBody()));
    }

    @Override
    public List<AirCompany> readAllByIds(List<Long> ids) {
        String uriVar = "read/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<AirCompanyDTO[]> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.POST, httpEntity, AirCompanyDTO[].class);
        return airCompanyMapper.toModel(Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList()));
    }

    @Override
    public AirCompany deleteById(Long id) {
        String uriVar = "delete/"+id+"/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AirCompanyDTO> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<AirCompanyDTO> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.DELETE, httpEntity, AirCompanyDTO.class);
        return airCompanyMapper.toModel(Objects.requireNonNull(responseEntity.getBody()));
    }

    @Override
    public List<AirCompany> deleteAllByIds(List<Long> ids) {
        String uriVar = "delete/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<AirCompanyDTO[]> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.DELETE, httpEntity, AirCompanyDTO[].class);
        return airCompanyMapper.toModel(Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList()));
    }

    @Override
    public AirCompany update(AirCompany airCompany) {
        String uriVar = "update";
        HttpEntity<AirCompanyDTO> httpEntity = new HttpEntity<>(airCompanyMapper.toDTO(airCompany));
        ResponseEntity<AirCompanyDTO> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.PUT, httpEntity, AirCompanyDTO.class);
        return airCompanyMapper.toModel(Objects.requireNonNull(responseEntity.getBody()));
    }
}
