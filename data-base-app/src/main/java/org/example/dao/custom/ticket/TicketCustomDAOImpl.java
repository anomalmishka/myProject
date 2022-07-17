package org.example.dao.custom.ticket;

import lombok.RequiredArgsConstructor;
import org.example.model.entity.Ticket;
import org.example.model.entity.Ticket_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class TicketCustomDAOImpl implements TicketCustomDAO{
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<Ticket> findAllTicketWhereUser(Long idUser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> query = criteriaBuilder.createQuery(Ticket.class);
        Root<Ticket> root = query.from(Ticket.class);
        Predicate predicate = criteriaBuilder.equal(root.get(Ticket_.user), idUser);
        query.where(predicate);
        return entityManager.createQuery(query).getResultList();
    }
}
