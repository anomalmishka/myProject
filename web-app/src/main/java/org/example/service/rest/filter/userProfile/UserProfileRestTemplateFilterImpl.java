package org.example.service.rest.filter.userProfile;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.AirCompanyDTO;
import org.example.dto.models.SeatDTO;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserProfileRestTemplateFilterImpl implements UserProfileRestTemplateFilter {

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    @Value(value = "${server.data-base-app.url}")
    private String DATA_BASE_APP_URL;

    @Override
    public UserProfileDTOModif findWhereUserId(Long userId) {
        String url = DATA_BASE_APP_URL + "/buisness/filter/user/profile/where/user/" + userId + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserProfileDTOModif> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<UserProfileDTOModif> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET,
                        httpEntity, UserProfileDTOModif.class);
        return responseEntity.getBody();
    }
}
