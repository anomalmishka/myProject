package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.AirCompanyDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.AirCompany;
import org.example.model.AirPlane;
import org.example.model.User;
import org.example.service.api.AirCompanyService;
import org.example.service.api.AirPlaneService;
import org.example.service.api.BuisnessService;
import org.example.service.api.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class BuisnessServiceImpl implements BuisnessService {

    private final AirCompanyService airCompanyService;


    @Override
    public AirCompany createAirCompanyWithAll(AirCompany airCompany) {
        return airCompanyService.create(airCompany);
    }
}
