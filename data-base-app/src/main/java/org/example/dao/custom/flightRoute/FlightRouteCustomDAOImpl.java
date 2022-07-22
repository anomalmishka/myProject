package org.example.dao.custom.flightRoute;

import lombok.RequiredArgsConstructor;
import org.example.model.entity.*;
import org.example.model.filter.FilterObj;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Repository
public class FlightRouteCustomDAOImpl implements FlightRouteCustomDAO {
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<FlightRoute> findFlightRouteWhereRouteStartAndRouteEnd(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();
        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        query.where(criteriaBuilder.and(predicateRouteStart, predicateRouteEnd));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findFlightRouteWhereDateStartAndDateEnd(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Date flightDateStart = filterObj.getDateStart();
        Date flightDateEnd = filterObj.getDateEnd();
        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.flightDateStart), flightDateStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.flightDateEnd), flightDateEnd);
        query.where(criteriaBuilder.and(predicateRouteStart, predicateRouteEnd));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FlightRoute> findFlightRouteWherePriceStartAndPriceEnd(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        Integer priceStart = filterObj.getPriceStart();
        Integer priceEnd = filterObj.getPriceEnd();

        Integer distance = 1000;
        Predicate predicateDistance = criteriaBuilder.equal(root.get(FlightRoute_.distance), distance);


        Integer pricePerKilometer = 5;
        Subquery<AirPlane> airPlaneSubquery = query.subquery(AirPlane.class);
        Root<AirPlane> airPlaneRoot = airPlaneSubquery.from(AirPlane.class);
        Predicate predicatePricePerKilometer = criteriaBuilder.equal(airPlaneRoot.get(AirPlane_.pricePerKilometer), pricePerKilometer);
        airPlaneSubquery.select(airPlaneRoot).where(predicatePricePerKilometer);

        Integer priceLowcostIndex = 1;
        Integer priceBuisnessIndex = 2;

        Subquery<AirCompany> airCompanySubquery = query.subquery(AirCompany.class);
        Root<AirCompany> airCompanyRoot = airPlaneSubquery.from(AirCompany.class);
        Predicate predicatePriceLowcostIndex = criteriaBuilder.equal(airCompanyRoot.get(AirCompany_.priceLowcostIndex), priceLowcostIndex);
        Predicate predicatePriceBuisnessIndex = criteriaBuilder.equal(airCompanyRoot.get(AirCompany_.priceBuisnessIndex), priceBuisnessIndex);
        airPlaneSubquery.select(airPlaneRoot).where(criteriaBuilder.and(predicatePriceLowcostIndex, predicatePriceBuisnessIndex));
        query.select(root).where(criteriaBuilder.between(root.get("itemPrice"), 100, 200));

//        Predicate predicatePriceStart = criteriaBuilder.equal(root.get(FlightRoute_.p), priceStart);
//        Predicate predicatePriceEnd = criteriaBuilder.equal(root.get(AirPlane_.priceLowcost), priceEnd);
//        query.where(criteriaBuilder.and(predicatePriceStart, predicatePriceEnd));
//        return entityManager.createQuery(query).getResultList();
        return  null;
    }

    @Override
    public List<FlightRoute> findFlightRouteWhereRouteSEAndDateSE(FilterObj filterObj) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
//        Root<FlightRoute> root = query.from(FlightRoute.class);
//        String routeStart = filterObj.getRouteStart();
//        String routeEnd = filterObj.getRouteEnd();
//        Date dateStart = filterObj.getDateStart();
//        Date dateEnd = filterObj.getDateEnd();
//        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
//        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
//        Predicate predicateDateStart = criteriaBuilder.equal(root.get(FlightRoute_.flightDateStart), dateStart);
//        Predicate predicateDateEnd = criteriaBuilder.equal(root.get(FlightRoute_.flightDateEnd), dateEnd);
//        List<Predicate> predicateList = new ArrayList<>();
//        predicateList.add(criteriaBuilder.and(predicateRouteStart, predicateRouteEnd));
//        predicateList.add(criteriaBuilder.and(predicateDateStart, predicateDateEnd));
//        query.where(criteriaBuilder.and(predicateList.toArray(Predicate[]::new)));
//        return entityManager.createQuery(query).getResultList();
        return null;
    }

    @Override
    public List<FlightRoute> findFlightRouteWhereRouteSEAndPriceSE(FilterObj filterObj) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
//        Root<FlightRoute> root = query.from(FlightRoute.class);
//        String routeStart = filterObj.getRouteStart();
//        String routeEnd = filterObj.getRouteEnd();
//        Join<FlightRoute, AirPlane> airPlaneJoin = root.join(FlightRoute_.airPlane);
//        Integer priceStart = filterObj.getPriceStart();
//        Integer priceEnd = filterObj.getPriceEnd();
//        Predicate predicatePriceStart = criteriaBuilder.equal(airPlaneJoin.get(AirPlane_.priceLowcost), priceStart);
//        Predicate predicatePriceEnd = criteriaBuilder.equal(airPlaneJoin.get(AirPlane_.priceLowcost), priceEnd);
//        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
//        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
//        List<Predicate> predicateList = new ArrayList<>();
//        predicateList.add(criteriaBuilder.and(predicateRouteStart, predicateRouteEnd));
//        predicateList.add(criteriaBuilder.and(predicatePriceStart, predicatePriceEnd));
//        query.where(criteriaBuilder.and(predicateList.toArray(Predicate[]::new)));
//        return entityManager.createQuery(query).getResultList();
        return null;
    }

    @Override
    public List<FlightRoute> findFlightRouteWhereDateSEAndPriceSE(FilterObj filterObj) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
//        Root<FlightRoute> root = query.from(FlightRoute.class);
//        Date dateStart = filterObj.getDateStart();
//        Date dateEnd = filterObj.getDateEnd();
//        Join<FlightRoute, AirPlane> airPlaneJoin = root.join(FlightRoute_.airPlane);
//        Integer priceStart = filterObj.getPriceStart();
//        Integer priceEnd = filterObj.getPriceEnd();
//        Predicate predicatePriceStart = criteriaBuilder.equal(airPlaneJoin.get(AirPlane_.priceLowcost), priceStart);
//        Predicate predicatePriceEnd = criteriaBuilder.equal(airPlaneJoin.get(AirPlane_.priceLowcost), priceEnd);
//        Predicate predicateDateStart = criteriaBuilder.equal(root.get(FlightRoute_.flightDateStart), dateStart);
//        Predicate predicateDateEnd = criteriaBuilder.equal(root.get(FlightRoute_.flightDateEnd), dateEnd);
//        List<Predicate> predicateList = new ArrayList<>();
//        predicateList.add(criteriaBuilder.and(predicateDateStart, predicateDateEnd));
//        predicateList.add(criteriaBuilder.and(predicatePriceStart, predicatePriceEnd));
//        query.where(criteriaBuilder.and(predicateList.toArray(Predicate[]::new)));
//        return entityManager.createQuery(query).getResultList();
        return null;
    }

    @Override
    public List<FlightRoute> findFlightRouteWhereRouteSEAndDateSEAndPriceSE(FilterObj filterObj) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
//        Root<FlightRoute> root = query.from(FlightRoute.class);
//        Join<FlightRoute, AirPlane> airPlaneJoin = root.join(FlightRoute_.airPlane);
//        String routeStart = filterObj.getRouteStart();
//        String routeEnd = filterObj.getRouteEnd();
//        Date dateStart = filterObj.getDateStart();
//        Date dateEnd = filterObj.getDateEnd();
//        Integer priceStart = filterObj.getPriceStart();
//        Integer priceEnd = filterObj.getPriceEnd();
//        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
//        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
//        Predicate predicateDateStart = criteriaBuilder.equal(root.get(FlightRoute_.flightDateStart), dateStart);
//        Predicate predicateDateEnd = criteriaBuilder.equal(root.get(FlightRoute_.flightDateEnd), dateEnd);
//        Predicate predicatePriceStart = criteriaBuilder.equal(airPlaneJoin.get(AirPlane_.priceLowcost), priceStart);
//        Predicate predicatePriceEnd = criteriaBuilder.equal(airPlaneJoin.get(AirPlane_.priceLowcost), priceEnd);
//        List<Predicate> predicateList = new ArrayList<>();
//        predicateList.add(criteriaBuilder.and(predicateRouteStart, predicateRouteEnd));
//        predicateList.add(criteriaBuilder.and(predicateDateStart, predicateDateEnd));
//        predicateList.add(criteriaBuilder.and(predicatePriceStart, predicatePriceEnd));
//        query.where(criteriaBuilder.and(predicateList.toArray(Predicate[]::new)));
//        return entityManager.createQuery(query).getResultList();
        return null;
    }

    @Override
    public List<FlightRoute> findFlightRouteWhereRouteSEOneWaypoint(FilterObj filterObj) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightRoute> query = criteriaBuilder.createQuery(FlightRoute.class);
        Root<FlightRoute> root = query.from(FlightRoute.class);
        String routeStart = filterObj.getRouteStart();
        String routeEnd = filterObj.getRouteEnd();

        //выбираю все самолеты вылетающие из routeStart
        Predicate predicateFindAllPlaneWhereRouteStart = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        query.where(predicateFindAllPlaneWhereRouteStart);
        List<FlightRoute> resultRouteStartList = entityManager.createQuery(query).getResultList();

        //выбираю из этих самолетов те, у которых есть routeEnd
        List<String> routeEndList = resultRouteStartList.stream().map(FlightRoute::getRouteEnd).collect(Collectors.toList());
        List<Predicate> predicateRoute = routeEndList.stream()
                .map(routeEndSecond -> criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeEndSecond))
                .collect(Collectors.toList());
        Predicate or = criteriaBuilder.or(predicateRoute.toArray(Predicate[]::new));
        Predicate equal = criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEnd);
        Predicate and = criteriaBuilder.and(or, equal);
        query.where(and);
        List<FlightRoute> resultListRouteEnd = entityManager.createQuery(query).getResultList();

        //выбираю для найденных routeStart wayPoint routeEnd
        List<String> routeStartList = resultListRouteEnd.stream().map(FlightRoute::getRouteStart).collect(Collectors.toList());
        System.out.println(routeStartList); //[Minsk-moskva, Paris-moskva]

        List<Predicate> predicateRouteEnd = routeStartList.stream()
                .map(routeEndSecond -> criteriaBuilder.equal(root.get(FlightRoute_.routeEnd), routeEndSecond))
                .collect(Collectors.toList());
        Predicate orSecond = criteriaBuilder.or(predicateRouteEnd.toArray(Predicate[]::new));
        Predicate equalSecond = criteriaBuilder.equal(root.get(FlightRoute_.routeStart), routeStart);
        Predicate andSecond = criteriaBuilder.and(orSecond, equalSecond);
        query.where(andSecond);
        List<FlightRoute> resultListRouteStart = entityManager.createQuery(query).getResultList();

        return Stream.concat(resultListRouteStart.stream(), resultListRouteEnd.stream())
                .collect(Collectors.toList());
    }
}
