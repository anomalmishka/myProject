package org.example.dao.custom.airPlane;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
@Repository
public class AirPlaneCustomDAOImpl implements AirPlaneCustomDAO {

    private final EntityManagerFactory entityManagerFactory;
}