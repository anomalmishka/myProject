package org.example.dao.custom.status;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
@Repository
public class StatusCustomDAOImpl implements StatusCustomDAO {
    private final EntityManagerFactory entityManagerFactory;
}
