package org.example.service.models;

import lombok.RequiredArgsConstructor;
import org.example.dao.crud.PassengerProfileDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.PassengerProfile;
import org.example.service.models.api.PassengerProfileService;
import org.example.service.models.api.UserOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class PassengerProfileServiceImpl implements PassengerProfileService {
    private final PassengerProfileDAO passengerProfileDAO;
    private final UserOrderService userOrderService;

    @Override
    public PassengerProfile create(PassengerProfile passengerProfile) {
        if (passengerProfile.getUsername() != null) {
            return passengerProfileDAO.save(passengerProfile);
        } else {
            throw new ErrorInvalidData("Name must not be null");
        }
    }

    @Override
    public List<PassengerProfile> readAll() {
        return StreamSupport
                .stream(passengerProfileDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public PassengerProfile readById(Long id) {
        return passengerProfileDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<PassengerProfile> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(passengerProfileDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public PassengerProfile deleteById(Long id) {
        PassengerProfile deleteEntity = passengerProfileDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
        passengerProfileDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<PassengerProfile> deleteAllByIds(List<Long> ids) {
        List<PassengerProfile> deleteEntities = readAllByIds(ids);
        passengerProfileDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public PassengerProfile update(PassengerProfile passengerProfile) {
        if (passengerProfile.getUsername() != null) {
            return passengerProfileDAO.save(passengerProfile);
        } else {
            throw new ErrorInvalidData("Name must not be null");
        }
    }
}
