package org.example.service.rest.models.userOrder;

import org.example.dto.models.modif.UserOrderDTOModif;
import org.example.dto.models.modif.UserOrderDTOtoSave;
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
public class UserOrderRestTemlateServiceImpl implements UserOrderRestTemlateService {
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    @Value(value = "${server.data-base-app.url}")
    private String DATA_BASE_APP_URL;
    private final String PATH = "/modif/user/order/";

    @Override
    public List<UserOrderDTOModif> readAll() {
        String uriVar = "read/all";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserOrderDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<UserOrderDTOModif[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, UserOrderDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public UserOrderDTOModif readById(Long id) {
        String uriVar = "read/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserOrderDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<UserOrderDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.GET, httpEntity, UserOrderDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<UserOrderDTOModif> readAllByIds(List<Long> ids) {
        String uriVar = "read/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<UserOrderDTOModif[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, UserOrderDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }

    @Override
    public UserOrderDTOModif create(UserOrderDTOtoSave userOrderDTOtoSave) {
        String uriVar = "create";
        HttpEntity<UserOrderDTOtoSave> httpEntity = new HttpEntity<>(userOrderDTOtoSave);
        ResponseEntity<UserOrderDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST, httpEntity, UserOrderDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public UserOrderDTOModif update(UserOrderDTOModif userOrderDTOModif) {
        String uriVar = "update";
        HttpEntity<UserOrderDTOModif> httpEntity = new HttpEntity<>(userOrderDTOModif);
        ResponseEntity<UserOrderDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.PUT, httpEntity, UserOrderDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public UserOrderDTOModif deleteById(Long id) {
        String uriVar = "delete/" + id + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserOrderDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<UserOrderDTOModif> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, UserOrderDTOModif.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @Override
    public List<UserOrderDTOModif> deleteAllByIds(List<Long> ids) {
        String uriVar = "delete/all/id";
        HttpEntity<List<Long>> httpEntity = new HttpEntity<>(ids);
        ResponseEntity<UserOrderDTOModif[]> responseEntity = restTemplate.exchange(
                DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.DELETE, httpEntity, UserOrderDTOModif[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
