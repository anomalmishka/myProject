package org.example.service.models.api;

import org.example.model.entity.PassengerProfile;

import java.util.List;

public interface PassengerProfileService {

    PassengerProfile create(PassengerProfile passengerProfile);

    List<PassengerProfile> readAll();

    PassengerProfile readById(Long id);

    List<PassengerProfile> readAllByIds(List<Long> ids);

    PassengerProfile deleteById(Long id);

    List<PassengerProfile> deleteAllByIds(List<Long> ids);

    PassengerProfile update(PassengerProfile passengerProfile);
}

