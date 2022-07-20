package org.example.dao.custom.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
@Repository
public class OrderCustomDAOImpl implements OrderCustomDAO {
    private final EntityManagerFactory entityManagerFactory;
}
