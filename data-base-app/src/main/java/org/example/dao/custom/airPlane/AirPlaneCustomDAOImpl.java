package org.example.dao.custom.airPlane;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
@Repository
public class AirPlaneCustomDAOImpl implements AirPlaneCustomDAO {

    private final EntityManagerFactory entityManagerFactory;

//    @Override
//    public List<Integer> getTotalPriceFly(Long idAirPlane) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<AirPlane> query = criteriaBuilder.createQuery(AirPlane.class);
//        Root<AirPlane> root = query.from(AirPlane.class);
//        Join<AirPlane,FlightRoute> flightRouteJoin = root.join(AirPlane_.flightRouteList);
//        Predicate findAirPlaneByID = criteriaBuilder.equal(root.get(AirPlane_.id), idAirPlane);
//        Predicate findFlightRouteList = criteriaBuilder.equal(root.get(AirPlane_.flightRouteList), idAirPlane);
//        query.select(root).where(findAirPlaneByID);
////        Subquery<AirPlane> airPlaneSubquery = query.subquery(AirPlane.class);
////        Root<AirPlane> airPlaneRoot = airPlaneSubquery.from(AirPlane.class);
////        Predicate predicatePricePerKilometer = criteriaBuilder.equal(airPlaneRoot.get(AirPlane_.pricePerKilometer), pricePerKilometer);
////        airPlaneSubquery.select(airPlaneRoot).where(predicatePricePerKilometer);
//
//
//        entityManager.createQuery(query).getResultList();
//        return null;
//    }
}