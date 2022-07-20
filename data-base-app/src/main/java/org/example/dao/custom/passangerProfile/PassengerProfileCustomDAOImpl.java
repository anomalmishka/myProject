package org.example.dao.custom.passangerProfile;

import lombok.RequiredArgsConstructor;
import org.example.model.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class PassengerProfileCustomDAOImpl implements PassengerProfileCustomDAO {
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<PassengerProfile> findAllPassengerProfileWhereAirCompany(Long idAirCompany) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PassengerProfile> query = criteriaBuilder.createQuery(PassengerProfile.class);
        Root<PassengerProfile> root = query.from(PassengerProfile.class);
        Join<PassengerProfile, Ticket> ticketJoin = root.join(PassengerProfile_.ticket, JoinType.LEFT);
        Join<Ticket, Seat> placeJoin = ticketJoin.join(Ticket_.seat, JoinType.LEFT);
        Join<Seat, AirPlane> airPlaneJoin = placeJoin.join(Seat_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        Predicate predicate = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.id), idAirCompany);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public List<PassengerProfile> findAllPassengerProfileWhereAirPlane(Long idAirPlane) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PassengerProfile> query = criteriaBuilder.createQuery(PassengerProfile.class);
        Root<PassengerProfile> root = query.from(PassengerProfile.class);
        Join<PassengerProfile, Ticket> ticketJoin = root.join(PassengerProfile_.ticket, JoinType.LEFT);
        Join<Ticket, Seat> placeJoin = ticketJoin.join(Ticket_.seat, JoinType.LEFT);
        Join<Seat, AirPlane> airPlaneJoin = placeJoin.join(Seat_.airPlane, JoinType.LEFT);
        Predicate predicate = criteriaBuilder.equal(airPlaneJoin.get(AirPlane_.id), idAirPlane);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }
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