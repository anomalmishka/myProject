package org.example.service.models.passengerProfileCustom;

import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.dto.models.modif.UserProfileDTOModif;

import java.security.Principal;
import java.util.List;

public interface PassengerProfileCustomService {
    List<PassengerProfileDTOModif> create(PassengerProfileDTOModif passengerProfileDTOModif, Principal principal);
    List<PassengerProfileDTOModif> getPassanger(Principal principal);
    List<PassengerProfileDTOModif> readPassangerProfile(UserProfileDTOModif userProfileDTOModif);
}
