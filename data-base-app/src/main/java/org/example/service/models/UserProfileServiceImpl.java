package org.example.service.models;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.UserProfileDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.UserProfile;
import org.example.service.models.api.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileDAO userProfileDAO;

    @Override
    public UserProfile create(UserProfile userProfile) {
        if (userProfile.getName() != null) {
            return userProfileDAO.save(userProfile);
        } else {
            throw new ErrorInvalidData("Name must not be null");
        }
    }

    @Override
    public List<UserProfile> readAll() {
        return StreamSupport
                .stream(userProfileDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public UserProfile readById(Long id) {
        return userProfileDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<UserProfile> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(userProfileDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public UserProfile deleteById(Long id) {
        UserProfile deleteEntity = userProfileDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
        userProfileDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<UserProfile> deleteAllByIds(List<Long> ids) {
        List<UserProfile> deleteEntities = readAllByIds(ids);
        userProfileDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public UserProfile update(UserProfile userProfile) {
        if (userProfile.getName() != null) {
            return userProfileDAO.save(userProfile);
        } else {
            throw new ErrorInvalidData("Name must not be null");
        }
    }
}
