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
