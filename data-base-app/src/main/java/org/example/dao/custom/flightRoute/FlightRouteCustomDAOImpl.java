package org.example.dao.custom.flightRoute;

import lombok.RequiredArgsConstructor;
import org.example.model.entity.*;
import org.example.model.filter.FilterObj;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
@Transactional
public class FlightRouteCustomDAOImpl implements FlightRouteCustomDAO {
    private final EntityManagerFactory entityManagerFactory;

    //**************************************1***************************************************
    @Override
    public List<FlightRoute> findWhereName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        String airCompanyName = filterObj.getAirCompanyName();
        Predicate predicate = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);
        query.where(predicate);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRouteStart(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        query.where(predicateRouteStart).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    //**************************************2***************************************************
    @Override
    public List<FlightRoute> findWhereRoute(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicate = criteriaBuilder.and(predicateRouteStart, predicateRouteEnd);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereDate(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        Predicate predicate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWherePrice(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);
        query.where(predicatePrice).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereDuration(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Integer durationEnd = filterObj.getDurationEnd();
        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    //**************************************3***************************************************

    @Override
    public List<FlightRoute> findWhereRouteName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        String airCompanyName = filterObj.getAirCompanyName();
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRouteAnd = criteriaBuilder.and(predicateRouteStart, predicateRouteEnd);
        Predicate predicateName = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);
        Predicate predicate = criteriaBuilder.and(predicateRouteAnd, predicateName);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereDateName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        String airCompanyName = filterObj.getAirCompanyName();
        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        Predicate predicateDateAnd = criteriaBuilder.and(predicateDateStart, predicateDateEnd);
        Predicate predicateName = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);
        Predicate predicate = criteriaBuilder.and(predicateDateAnd, predicateName);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWherePriceName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        String airCompanyName = filterObj.getAirCompanyName();
        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);
        Predicate predicateName = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);
        Predicate predicate = criteriaBuilder.and(predicatePrice, predicateName);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRouteTransfer(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        String transfers = filterObj.getTransfers();
        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), transfers);
        Predicate predicateTransferStart = criteriaBuilder.and(predicateRouteStart, predicateRouteEnd);
        Predicate predicateRouteStart2 = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), transfers);
        Predicate predicateRouteEnd2 = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateTransferEnd = criteriaBuilder.and(predicateRouteStart2, predicateRouteEnd2);
        Predicate predicate = criteriaBuilder.or(predicateTransferStart, predicateTransferEnd);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    //**************************************4***************************************************

    @Override
    public List<FlightRoute> findWhereRouteDate(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRouteAnd = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);
        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        Predicate predicateDateAnd = criteriaBuilder.and(predicateDateStart, predicateDateEnd);
        Predicate predicate = criteriaBuilder.and(predicateRouteAnd, predicateDateAnd);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRoutePrice(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);
        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);
        Predicate predicate = criteriaBuilder.and(predicateRoute, predicatePrice);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRouteDuration(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);
        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateRoute);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereDatePrice(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);
        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);
        Predicate predicate = criteriaBuilder.and(predicateDate, predicatePrice);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereDateDuration(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);
        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateDate);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWherePriceDuration(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);
        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicatePrice);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    //**************************************5***************************************************

    @Override
    public List<FlightRoute> findWhereRouteDateName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        String airCompanyName = filterObj.getAirCompanyName();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRouteAnd = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);
        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateEnd);
        Predicate predicateDateAnd = criteriaBuilder.and(predicateDateStart, predicateDateEnd);
        Predicate predicateRouteDate = criteriaBuilder.and(predicateRouteAnd, predicateDateAnd);
        Predicate predicateName = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);
        Predicate predicate = criteriaBuilder.and(predicateRouteDate, predicateName);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRoutePriceName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        String airCompanyName = filterObj.getAirCompanyName();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);
        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);
        Predicate predicateName = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);
        Predicate predicateRoutePrice = criteriaBuilder.and(predicateRoute, predicatePrice);
        Predicate predicate = criteriaBuilder.and(predicateRoutePrice, predicateName);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRouteDurationName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);
        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateRoute);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereDatePriceName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        String airCompanyName = filterObj.getAirCompanyName();
        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);
        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);
        Predicate predicateDatePrice = criteriaBuilder.and(predicateDate, predicatePrice);
        Predicate predicateName = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);
        Predicate predicate = criteriaBuilder.and(predicateDatePrice, predicateName);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereDateDurationName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        String airCompanyName = filterObj.getAirCompanyName();
        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);
        Predicate predicateName = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);
        Predicate predicateDateName = criteriaBuilder.and(predicateDate, predicateName);
        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateDateName);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWherePriceDurationName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        String airCompanyName = filterObj.getAirCompanyName();
        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);
        Predicate predicateName = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);
        Predicate predicatePriceName = criteriaBuilder.and(predicatePrice, predicateName);
        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicatePriceName);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRouteDateTransfer(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        String transfers = filterObj.getTransfers();
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);
        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), transfers);
        Predicate predicateTransferStart = criteriaBuilder.and(predicateRouteStart, predicateRouteEnd);
        Predicate predicateRouteStart2 = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), transfers);
        Predicate predicateRouteEnd2 = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateTransferEnd = criteriaBuilder.and(predicateRouteStart2, predicateRouteEnd2);
        Predicate predicateTransfer = criteriaBuilder.or(predicateTransferStart, predicateTransferEnd);
        Predicate predicate = criteriaBuilder.or(predicateTransfer, predicateDate);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRoutePriceTransfer(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        String transfers = filterObj.getTransfers();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);

        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), transfers);
        Predicate predicateTransferStart = criteriaBuilder.and(predicateRouteStart, predicateRouteEnd);

        Predicate predicateRouteStart2 = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), transfers);
        Predicate predicateRouteEnd2 = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateTransferEnd = criteriaBuilder.and(predicateRouteStart2, predicateRouteEnd2);

        Predicate predicateTransfer = criteriaBuilder.or(predicateTransferStart, predicateTransferEnd);

        Predicate predicate = criteriaBuilder.and(predicateTransfer, predicatePrice);

        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRouteDurationTransfer(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        String transfers = filterObj.getTransfers();
        Integer durationEnd = filterObj.getDurationEnd();
        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), transfers);
        Predicate predicateTransferStart = criteriaBuilder.and(predicateRouteStart, predicateRouteEnd);

        Predicate predicateRouteStart2 = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), transfers);
        Predicate predicateRouteEnd2 = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateTransferEnd = criteriaBuilder.and(predicateRouteStart2, predicateRouteEnd2);

        Predicate predicateTransfer = criteriaBuilder.or(predicateTransferStart, predicateTransferEnd);

        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateTransfer);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    //**************************************6***************************************************

    @Override
    public List<FlightRoute> findWhereRouteDatePrice(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);

        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);

        Predicate predicateRouteDate = criteriaBuilder.and(predicateRoute, predicateDate);

        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);

        Predicate predicate = criteriaBuilder.and(predicateRouteDate, predicatePrice);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRouteDateDuration(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);

        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);

        Predicate predicateRouteDate = criteriaBuilder.and(predicateRoute, predicateDate);

        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateRouteDate);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRoutePriceDuration(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);

        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);

        Predicate predicateRoutePrice= criteriaBuilder.and(predicateRoute, predicatePrice);

        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateRoutePrice);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereDatePriceDuration(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);

        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);

        Predicate predicateDatePrice= criteriaBuilder.and(predicateDate, predicatePrice);

        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateDatePrice);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    //**************************************7***************************************************

    @Override
    public List<FlightRoute> findWhereRouteDatePriceName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        String airCompanyName = filterObj.getAirCompanyName();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);

        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);

        Predicate predicateRouteDate = criteriaBuilder.and(predicateRoute, predicateDate);

        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);

        Predicate predicateRouteDatePrice = criteriaBuilder.and(predicateRouteDate, predicatePrice);

        Predicate predicateName = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);
        Predicate predicate = criteriaBuilder.and(predicateRouteDatePrice, predicateName);
        query.where(predicate).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRouteDateDurationName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        String airCompanyName = filterObj.getAirCompanyName();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);

        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);

        Predicate predicateRouteDate = criteriaBuilder.and(predicateRoute, predicateDate);

        Predicate predicateName = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);
        Predicate predicateRouteDateName = criteriaBuilder.and(predicateRouteDate, predicateName);

        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateRouteDateName);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRoutePriceDurationName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        String airCompanyName = filterObj.getAirCompanyName();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);

        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);

        Predicate predicateRoutePrice = criteriaBuilder.and(predicateRoute, predicatePrice);

        Predicate predicateName = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);
        Predicate predicateRoutePriceName = criteriaBuilder.and(predicateRoutePrice, predicateName);

        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateRoutePriceName);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereDatePriceDurationName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        String airCompanyName = filterObj.getAirCompanyName();
        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);

        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);

        Predicate predicateDatePrice = criteriaBuilder.and(predicateDate, predicatePrice);

        Predicate predicateName = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);
        Predicate predicateDatePriceName = criteriaBuilder.and(predicateDatePrice, predicateName);

        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateDatePriceName);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRouteDatePriceTransfer(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        String transfers = filterObj.getTransfers();
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);

        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);

        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);

        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), transfers);
        Predicate predicateTransferStart = criteriaBuilder.and(predicateRouteStart, predicateRouteEnd);

        Predicate predicateRouteStart2 = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), transfers);
        Predicate predicateRouteEnd2 = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateTransferEnd = criteriaBuilder.and(predicateRouteStart2, predicateRouteEnd2);

        Predicate predicateTransfer = criteriaBuilder.or(predicateTransferStart, predicateTransferEnd);

        Predicate predicatePriceDate = criteriaBuilder.and(predicatePrice, predicateDate);

        Predicate predicateRouteTransfer = criteriaBuilder.or(predicateRoute, predicateTransfer);

        Predicate predicateRouteDatePriceTransfer = criteriaBuilder.and(predicateRouteTransfer, predicatePriceDate);
        query.where(predicateRouteDatePriceTransfer).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRouteDateDurationTransfer(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        String transfers = filterObj.getTransfers();
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);

        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);

        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), transfers);
        Predicate predicateTransferStart = criteriaBuilder.and(predicateRouteStart, predicateRouteEnd);

        Predicate predicateRouteStart2 = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), transfers);
        Predicate predicateRouteEnd2 = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateTransferEnd = criteriaBuilder.and(predicateRouteStart2, predicateRouteEnd2);

        Predicate predicateTransfer = criteriaBuilder.or(predicateTransferStart, predicateTransferEnd);

        Predicate predicateRouteTransfer = criteriaBuilder.or(predicateTransfer, predicateRoute);

        Predicate predicateRouteDateTransfer = criteriaBuilder.and(predicateRouteTransfer, predicateDate);

        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateRouteDateTransfer);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRoutePriceDurationTransfer(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        String transfers = filterObj.getTransfers();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);

        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);

        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), transfers);
        Predicate predicateTransferStart = criteriaBuilder.and(predicateRouteStart, predicateRouteEnd);

        Predicate predicateRouteStart2 = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), transfers);
        Predicate predicateRouteEnd2 = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateTransferEnd = criteriaBuilder.and(predicateRouteStart2, predicateRouteEnd2);

        Predicate predicateTransfer = criteriaBuilder.or(predicateTransferStart, predicateTransferEnd);

        Predicate predicateRouteTransfer = criteriaBuilder.or(predicateRoute, predicateTransfer);

        Predicate predicateRoutePriceTransfer = criteriaBuilder.and(predicateRouteTransfer, predicatePrice);

        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateRoutePriceTransfer);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    //**************************************8***************************************************

    @Override
    public List<FlightRoute> findWhereRouteDatePriceDuration(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);

        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);

        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);

        Predicate predicateRouteDate = criteriaBuilder.and(predicateRoute, predicateDate);

        Predicate predicateRouteDatePrice = criteriaBuilder.and(predicateRouteDate, predicatePrice);

        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateRouteDatePrice);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    //**************************************9***************************************************

    @Override
    public List<FlightRoute> findWhereRouteDatePriceDurationName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        String airCompanyName = filterObj.getAirCompanyName();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);

        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);

        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);

        Predicate predicateRouteDate = criteriaBuilder.and(predicateRoute, predicateDate);

        Predicate predicateRouteDatePrice = criteriaBuilder.and(predicateRouteDate, predicatePrice);
        Predicate predicateName = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);
        Predicate predicateRouteDatePriceName = criteriaBuilder.and(predicateRouteDatePrice, predicateName);

        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateRouteDatePriceName);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findWhereRouteDatePriceDurationTranfser(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        String transfers = filterObj.getTransfers();
        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);

        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);

        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);

        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), transfers);
        Predicate predicateTransferStart = criteriaBuilder.and(predicateRouteStart, predicateRouteEnd);

        Predicate predicateRouteStart2 = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), transfers);
        Predicate predicateRouteEnd2 = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateTransferEnd = criteriaBuilder.and(predicateRouteStart2, predicateRouteEnd2);

        Predicate predicateTransfer = criteriaBuilder.or(predicateTransferStart, predicateTransferEnd);

        Predicate predicateRouteTransfer = criteriaBuilder.or(predicateRoute, predicateTransfer);

        Predicate predicateDatePrice = criteriaBuilder.and(predicateDate, predicatePrice);

        Predicate predicateRouteDatePriceTransfer = criteriaBuilder.and(predicateRouteTransfer, predicateDatePrice);

        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateRouteDatePriceTransfer);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    //**************************************10**************************************************

    @Override
    public List<FlightRoute> findWhereRouteDatePriceDurationTranfserName(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Join<FlightRoute, AirPlaneFlightRoute> airPlaneFlightRouteJoin = root.join(FlightRoute_.airPlaneFlightRouteList, JoinType.LEFT);
        Join<AirPlaneFlightRoute, AirPlane> airPlaneJoin = airPlaneFlightRouteJoin.join(AirPlaneFlightRoute_.airPlane, JoinType.LEFT);
        Join<AirPlane, AirCompany> airCompanyJoin = airPlaneJoin.join(AirPlane_.airCompany, JoinType.LEFT);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Timestamp flightDateStart = filterObj.getDateStart();
        Timestamp flightDateEnd = filterObj.getDateEnd();
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();
        Integer durationEnd = filterObj.getDurationEnd();
        String transfers = filterObj.getTransfers();
        String airCompanyName = filterObj.getAirCompanyName();

        Predicate predicateRouteStartEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEndEqual = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateRoute = criteriaBuilder.and(predicateRouteStartEqual, predicateRouteEndEqual);

        Predicate predicateDateStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateDateEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        Predicate predicateDate = criteriaBuilder.and(predicateDateStart, predicateDateEnd);

        Predicate predicatePriceStart = criteriaBuilder.greaterThanOrEqualTo(root.get(FlightRoute_.price), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.lessThanOrEqualTo(root.get(FlightRoute_.price), priceEnd);
        Predicate predicatePrice = criteriaBuilder.and(predicatePriceStart, predicatePriceEnd);

        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), transfers);
        Predicate predicateTransferStart = criteriaBuilder.and(predicateRouteStart, predicateRouteEnd);

        Predicate predicateRouteStart2 = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), transfers);
        Predicate predicateRouteEnd2 = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate predicateTransferEnd = criteriaBuilder.and(predicateRouteStart2, predicateRouteEnd2);

        Predicate predicateTransfer = criteriaBuilder.or(predicateTransferStart, predicateTransferEnd);

        Predicate predicateRouteTransfer = criteriaBuilder.or(predicateRoute, predicateTransfer);

        Predicate predicateDatePrice = criteriaBuilder.and(predicateDate, predicatePrice);

        Predicate predicateRouteDatePriceTransfer = criteriaBuilder.and(predicateRouteTransfer, predicateDatePrice);

        Predicate predicateName = criteriaBuilder.equal(airCompanyJoin.get(AirCompany_.nameCompany), airCompanyName);

        Predicate predicateRouteDatePriceTransferName = criteriaBuilder.and(predicateRouteDatePriceTransfer, predicateName);

        Expression<String> SECOND = new TimestampdiffExpression(null, String.class, "SECOND");
        Expression<Integer> timeDiff = criteriaBuilder.function(
                "TIMESTAMPDIFF",
                Integer.class,
                SECOND,
                root.get("flightDateStart"),
                root.get("flightDateEnd"));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(predicateRouteDatePriceTransferName);
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(timeDiff, durationEnd));
        query.where(predicateList.toArray(new Predicate[]{})).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }
}
