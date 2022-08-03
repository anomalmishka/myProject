package org.example.service.rest.filter.userProfile;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class UserProfileRestTemplateFilterImpl implements UserProfileRestTemplateFilter {

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    @Value(value = "${server.data-base-app.url}")
    private String DATA_BASE_APP_URL;
    private final String PATH = "/buisness/filer/user/profile/";

    @Override
    public UserProfileDTOModif2 findWhereNameLastnameEmail(UserProfileDTOModif2 userProfileDTOModif2) {
        String uriVar = "where/user";
        ResponseEntity<UserProfileDTOModif2> responseEntity =
                restTemplate.exchange(DATA_BASE_APP_URL + PATH + uriVar, HttpMethod.POST,
                        new HttpEntity<>(userProfileDTOModif2), UserProfileDTOModif2.class);
        return responseEntity.getBody();
    }
}
