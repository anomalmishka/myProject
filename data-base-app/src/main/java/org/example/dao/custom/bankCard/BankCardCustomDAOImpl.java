package org.example.dao.custom.bankCard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
@Repository
public class BankCardCustomDAOImpl implements BankCardCustomDAO {
    private final EntityManagerFactory entityManagerFactory;
}
