package org.example.service.models.passengerProfile;

import org.example.dto.models.modif.PassengerProfileDTOModif;

import java.util.List;

public interface PassengerProfileService {
    PassengerProfileDTOModif create(PassengerProfileDTOModif passengerProfileDTOModif);

    List<PassengerProfileDTOModif> readAll();

    PassengerProfileDTOModif readById(Long id);

    List<PassengerProfileDTOModif> readAllByIds(List<Long> ids);

    PassengerProfileDTOModif deleteById(Long id);

    List<PassengerProfileDTOModif> deleteAllByIds(List<Long> ids);

    PassengerProfileDTOModif update(PassengerProfileDTOModif passengerProfileDTOModif);
}
