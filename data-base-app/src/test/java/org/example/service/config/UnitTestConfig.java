package org.example.service.config;

import org.example.dao.custom.airPlane.AirPlaneCustomDAO;
import org.example.dao.custom.airPlane.AirPlaneCustomDAOImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManagerFactory;

@TestConfiguration
public class UnitTestConfig {
    @Bean
    @Profile("test")
    AirPlaneCustomDAO airPlaneCustomDAOImpl(EntityManagerFactory managerFactory) {
        return new AirPlaneCustomDAOImpl(managerFactory);
    }
}
