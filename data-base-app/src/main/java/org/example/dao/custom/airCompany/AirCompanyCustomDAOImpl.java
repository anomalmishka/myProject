package org.example.dao.custom.airCompany;

import lombok.RequiredArgsConstructor;
import org.example.model.entity.*;
import org.example.model.filter.FilterObj;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;
import java.util.List;
@RequiredArgsConstructor
@Repository
public class AirCompanyCustomDAOImpl implements AirCompanyCustomDAO{
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<AirCompany> findAirCompanyWhereRouteStartAndRouteEnd(FilterObj filterObj) {
        System.out.println(filterObj);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AirCompany> query = criteriaBuilder.createQuery(AirCompany.class);
        Root<AirCompany> root = query.from(AirCompany.class);
        Join<AirCompany, AirPlane> airPlaneJoin = root.join(AirCompany_.airPlaneList, JoinType.LEFT);
//        root.fetch(AirCompany_.airPlaneList, JoinType.LEFT);
        Join<AirPlane, FlightRoute> flightRouteJoin = airPlaneJoin.join(AirPlane_.flightRouteList, JoinType.LEFT);
//        airPlaneJoin.fetch(AirPlane_.flightRouteList, JoinType.LEFT);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Predicate predicateRouteStart = criteriaBuilder.equal(flightRouteJoin.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(flightRouteJoin.get(FlightRoute_.routeEnd), routeEnd);
        query.where(criteriaBuilder.and(predicateRouteStart, predicateRouteEnd)).distinct(true);
        List<AirCompany> resultList = entityManager.createQuery(query).getResultList();
        System.out.println(resultList);
        return resultList;
    }

    @Override
    public List<AirCompany> findAirCompanyWhereDateStartAndDateEnd(FilterObj filterObj) {
        return null;
    }

    @Override
    public List<AirCompany> findAirCompanyWhereRouteSEOneWaypoint(FilterObj filterObj) {
        return null;
    }

}
