package org.example.service.models.passengerProfile;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.service.rest.models.passengerProfile.PassengerProfileRestTemlateService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PassengerProfileServiceImpl implements PassengerProfileService {

    private final PassengerProfileRestTemlateService passengerProfileRestTemlateService;

    @Override
    public PassengerProfileDTOModif create(PassengerProfileDTOModif passengerProfileDTOModif) {
        return passengerProfileRestTemlateService.create(passengerProfileDTOModif);
    }

    @Override
    public List<PassengerProfileDTOModif> readAll() {
        return passengerProfileRestTemlateService.readAll();
    }

    @Override
    public PassengerProfileDTOModif readById(Long id) {
        return passengerProfileRestTemlateService.readById(id);
    }

    @Override
    public List<PassengerProfileDTOModif> readAllByIds(List<Long> ids) {
        return passengerProfileRestTemlateService.readAllByIds(ids);
    }

    @Override
    public PassengerProfileDTOModif deleteById(Long id) {
        return passengerProfileRestTemlateService.deleteById(id);
    }

    @Override
    public List<PassengerProfileDTOModif> deleteAllByIds(List<Long> ids) {
        return passengerProfileRestTemlateService.deleteAllByIds(ids);
    }

    @Override
    public PassengerProfileDTOModif update(PassengerProfileDTOModif passengerProfileDTOModif) {
        return passengerProfileRestTemlateService.update(passengerProfileDTOModif);
    }
}
