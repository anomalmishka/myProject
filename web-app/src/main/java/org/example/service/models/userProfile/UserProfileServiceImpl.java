package org.example.service.models.userProfile;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif2.UserProfileDTOModif2;
import org.example.service.rest.filter.userProfile.UserProfileRestTemplateFilter;
import org.example.service.rest.models.UserProfile.UserProfileRestTemlateService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRestTemlateService userProfileRestTemlateService;
    private final UserProfileRestTemplateFilter userProfileRestTemplateFilter;


    @Override
    public List<UserProfileDTOModif2> readAll() {
        return userProfileRestTemlateService.readAll();
    }

    @Override
    public UserProfileDTOModif2 readById(Long id) {
        return userProfileRestTemlateService.readById(id);
    }

    @Override
    public List<UserProfileDTOModif2> readAllByIds(List<Long> ids) {
        return userProfileRestTemlateService.readAllByIds(ids);
    }

    @Override
    public UserProfileDTOModif2 create(UserProfileDTOModif2 userProfileDTOModif2) {
        return userProfileRestTemlateService.create(userProfileDTOModif2);
    }

    @Override
    public UserProfileDTOModif2 update(UserProfileDTOModif2 userProfileDTOModif2) {
        return userProfileRestTemlateService.update(userProfileDTOModif2);
    }

    @Override
    public UserProfileDTOModif2 deleteById(Long id) {
        return userProfileRestTemlateService.deleteById(id);
    }

    @Override
    public List<UserProfileDTOModif2> deleteAllByIds(List<Long> ids) {
        return userProfileRestTemlateService.deleteAllByIds(ids);
    }

    @Override
    public UserProfileDTOModif2 findWhereNameLastnameEmail(UserProfileDTOModif2 userProfileDTOModif2) {
        return userProfileRestTemplateFilter.findWhereNameLastnameEmail(userProfileDTOModif2);
    }
}
