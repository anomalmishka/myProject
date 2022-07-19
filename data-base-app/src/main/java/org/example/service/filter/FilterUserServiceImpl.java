package org.example.service.filter;

import lombok.RequiredArgsConstructor;
import org.example.dao.custom.user.UserCustomDAO;
import org.example.model.entity.User;
import org.example.service.filter.api.FilterUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilterUserServiceImpl implements FilterUserService {

    private final UserCustomDAO userCustomDAO;

    @Override
    public List<User> findAllUserWhereAirCompany(Long idAirCompany) {
        return userCustomDAO.findAllUserWhereAirCompany(idAirCompany);
    }

    @Override
    public List<User> findAllUserWhereAirPlane(Long idAirPlane) {
        return userCustomDAO.findAllUserWhereAirPlane(idAirPlane);
    }

}