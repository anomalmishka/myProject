package org.example.service.rest.models.UserProfile;

import org.example.dto.models.modif.UserProfileDTOModif;
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
public class UserProfileRestTemlateServiceImpl implements UserProfileRestTemlateService {
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    @Value(value = "${server.data-base-app.url}")
    private String DATA_BASE_APP_URL;
    private final String PATH = "/modif/user/profile/";

    @Override
    public List<UserProfileDTOModif> readAll() {
        String uriVar = "read/all";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserProfileDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<UserProfileDTOModif[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, UserProfileDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public UserProfileDTOModif readById(Long id) {
        String uriVar = "read/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserProfileDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<UserProfileDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, UserProfileDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<UserProfileDTOModif> readAllByIds(List<Long> ids) {
        String uriVar = "read/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<UserProfileDTOModif[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, UserProfileDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public UserProfileDTOModif create(UserProfileDTOModif userProfileDTOModif) {
        String uriVar = "create";
        HttpEntity<UserProfileDTOModif> httpEntity = new HttpEntity<>(userProfileDTOModif);
        ResponseEntity<UserProfileDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, UserProfileDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public UserProfileDTOModif update(UserProfileDTOModif userProfileDTOModif) {
        String uriVar = "update";
        HttpEntity<UserProfileDTOModif> httpEntity = new HttpEntity<>(userProfileDTOModif);
        ResponseEntity<UserProfileDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.PUT, httpEntity, UserProfileDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public UserProfileDTOModif deleteById(Long id) {
        String uriVar = "delete/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserProfileDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<UserProfileDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, UserProfileDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<UserProfileDTOModif> deleteAllByIds(List<Long> ids) {
        String uriVar = "delete/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<UserProfileDTOModif[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, UserProfileDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
