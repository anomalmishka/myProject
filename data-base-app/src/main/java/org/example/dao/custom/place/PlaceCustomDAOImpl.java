package org.example.dao.custom.place;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
@Repository
public class PlaceCustomDAOImpl implements PlaceCustomDAO {
    private final EntityManagerFactory entityManagerFactory;
}
