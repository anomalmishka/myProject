package org.example.dao.custom;

import org.example.model.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class UserCustomDAOImpl implements UserCustomDAO {

    public UserCustomDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private final EntityManagerFactory entityManagerFactory;


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
}