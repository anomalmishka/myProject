package org.example.dao.custom.user;

import lombok.RequiredArgsConstructor;
import org.example.model.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;
import java.util.List;
@RequiredArgsConstructor
@Repository
public class UserCustomDAOImpl implements UserCustomDAO {
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<User> findAllUserWhereAirCompany(Long idAirCompany) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Join<User, Ticket> ticketJoin = root.join(User_.tickets, JoinType.LEFT);
        Join<Ticket, AirPlane> airPlaneJoin = ticketJoin.join(Ticket_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        Predicate predicate = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.id), idAirCompany);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public List<User> findAllUserWhereAirPlane(Long idAirPlane) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Join<User, Ticket> ticketJoin = root.join(User_.tickets, JoinType.LEFT);
        Join<Ticket, AirPlane> airPlaneJoin = ticketJoin.join(Ticket_.airPlane, JoinType.LEFT);
        Predicate predicate = criteriaBuilder.equal(airPlaneJoin.get(AirPlane_.id), idAirPlane);
        query.where(predicate);
        return entityManager.createQuery(query).getResultList();
    }

//    @Override
//    public List<User> findAllUserWhereAirPlane(Long idAirPlane) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Query query = entityManager.createQuery(
//                "select u from USER u " +
//                        "join u.tickets t " +
//                        "join t.airPlane a " +
//                        "where a.id " +
//                        "= :idAirPlane ");
//        query.setParameter("idAirPlane", idAirPlane);
//        return query.getResultList();
//    }
}