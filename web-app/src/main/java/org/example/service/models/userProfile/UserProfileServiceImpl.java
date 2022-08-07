package org.example.service.models.userProfile;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserProfileDTOModif;
import org.example.service.rest.models.userProfile.UserProfileRestTemlateService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRestTemlateService userProfileRestTemlateService;


    @Override
    public List<UserProfileDTOModif> readAll() {
        return userProfileRestTemlateService.readAll();
    }

    @Override
    public UserProfileDTOModif readById(Long id) {
        return userProfileRestTemlateService.readById(id);
    }

    @Override
    public List<UserProfileDTOModif> readAllByIds(List<Long> ids) {
        return userProfileRestTemlateService.readAllByIds(ids);
    }

    @Override
    public UserProfileDTOModif create(UserProfileDTOModif userProfileDTOModif2) {
        return userProfileRestTemlateService.create(userProfileDTOModif2);
    }

    @Override
    public UserProfileDTOModif update(UserProfileDTOModif userProfileDTOModif2) {
        return userProfileRestTemlateService.update(userProfileDTOModif2);
    }

    @Override
    public UserProfileDTOModif deleteById(Long id) {
        return userProfileRestTemlateService.deleteById(id);
    }

    @Override
    public List<UserProfileDTOModif> deleteAllByIds(List<Long> ids) {
        return userProfileRestTemlateService.deleteAllByIds(ids);
    }
}
