package org.example.service.buisness;

import lombok.RequiredArgsConstructor;
import org.example.dao.custom.UserCustomDAO;
import org.example.model.User;
import org.example.service.api.buisness.BuisnessFilterUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BuisnessFilterUserServiceImpl implements BuisnessFilterUserService {

    private final UserCustomDAO userCustomDAO;

    @Override
    public List<User> findAllUserWhereAirPlane(Long idAirPlane) {
        return userCustomDAO.findAllUserWhereAirPlane(idAirPlane);
    }
}
