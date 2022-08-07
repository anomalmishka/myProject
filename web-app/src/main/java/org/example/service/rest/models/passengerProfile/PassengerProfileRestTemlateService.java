package org.example.service.rest.models.passengerProfile;

import org.example.dto.models.modif.PassengerProfileDTOModif;

import java.util.List;

public interface PassengerProfileRestTemlateService {
    List<PassengerProfileDTOModif> readAll();

    PassengerProfileDTOModif readById(Long id);

    List<PassengerProfileDTOModif> readAllByIds(List<Long> ids);

    PassengerProfileDTOModif create(PassengerProfileDTOModif passengerProfileDTOModif);

    PassengerProfileDTOModif update(PassengerProfileDTOModif passengerProfileDTOModif);

    PassengerProfileDTOModif deleteById(Long id);

    List<PassengerProfileDTOModif> deleteAllByIds(List<Long> ids);
}
