package org.example.service.rest.filter.userProfile;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.UserProfileDTO;
import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
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

    private final String URL = "http://localhost:8003/data-base-app/buisness/filter/user/profile/";


    @Override
    public UserProfileDTOModif2 findWhereNameLastnameEmail(UserProfileDTOModif2 userProfileDTOModif2) {
        String uriVar = "where/user";
        System.out.println("rest find user");
        ResponseEntity<UserProfileDTOModif2> responseEntity =
                restTemplate.exchange(URL + uriVar, HttpMethod.POST,
                        new HttpEntity<>(userProfileDTOModif2), UserProfileDTOModif2.class);
        return responseEntity.getBody();
    }
}
