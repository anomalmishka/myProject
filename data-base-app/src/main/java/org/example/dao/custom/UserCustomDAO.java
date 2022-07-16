package org.example.dao.custom;


import org.example.model.User;

import java.util.List;

public interface UserCustomDAO {

    List<User> findAllUserWhereAirPlane(Long idAirPlane);

}
