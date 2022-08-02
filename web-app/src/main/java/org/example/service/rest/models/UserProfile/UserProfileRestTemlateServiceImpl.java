package org.example.service.rest.models.UserProfile;

import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserProfileRestTemlateServiceImpl implements UserProfileRestTemlateService {
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    private final String URL = "http://localhost:8003/data-base-app/user/profile/";

    @Override
    public List<UserProfileDTOModif2> readAll() {
        String uriVar = "read/all";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserProfileDTOModif2> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<UserProfileDTOModif2[]> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.GET, httpEntity, UserProfileDTOModif2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public UserProfileDTOModif2 readById(Long id) {
        String uriVar = "read/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserProfileDTOModif2> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<UserProfileDTOModif2> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.GET, httpEntity, UserProfileDTOModif2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<UserProfileDTOModif2> readAllByIds(List<Long> ids) {
        String uriVar = "read/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<UserProfileDTOModif2[]> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.POST, httpEntity, UserProfileDTOModif2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public UserProfileDTOModif2 create(UserProfileDTOModif2 userProfileDTOModif2) {
        String uriVar = "create";
        HttpEntity<UserProfileDTOModif2> httpEntity = new HttpEntity<>(userProfileDTOModif2);
        ResponseEntity<UserProfileDTOModif2> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.POST, httpEntity, UserProfileDTOModif2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public UserProfileDTOModif2 update(UserProfileDTOModif2 userProfileDTOModif2) {
        String uriVar = "update";
        HttpEntity<UserProfileDTOModif2> httpEntity = new HttpEntity<>(userProfileDTOModif2);
        ResponseEntity<UserProfileDTOModif2> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.PUT, httpEntity, UserProfileDTOModif2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public UserProfileDTOModif2 deleteById(Long id) {
        String uriVar = "delete/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserProfileDTOModif2> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<UserProfileDTOModif2> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.DELETE, httpEntity, UserProfileDTOModif2.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<UserProfileDTOModif2> deleteAllByIds(List<Long> ids) {
        String uriVar = "delete/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<UserProfileDTOModif2[]> responseEntity = restTemplate.exchange(URL + uriVar, HttpMethod.DELETE, httpEntity, UserProfileDTOModif2[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
