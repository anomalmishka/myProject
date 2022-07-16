package org.example.dao.custom;

import org.example.dto.api.FilterAirPlaneObject;
import org.example.model.AirPlane;
import org.example.model.AirPlane_;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class AirPlaneCustomDAOImpl implements AirPlaneCustomDAO {

    public AirPlaneCustomDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<AirPlane> findAirPlaneWhereRouteStartAndRouteEnd(FilterAirPlaneObject filterAirPlaneObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AirPlane> query = criteriaBuilder.createQuery(AirPlane.class);
        Root<AirPlane> root = query.from(AirPlane.class);
        String routeStart = filterAirPlaneObject.getRouteStart();
        String routeEnd = filterAirPlaneObject.getRouteEnd();
        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(AirPlane_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(AirPlane_.routeEnd), routeEnd);
        query.where(criteriaBuilder.and(predicateRouteStart, predicateRouteEnd));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<AirPlane> findAirPlaneWhereDateStartAndDateEnd(FilterAirPlaneObject filterAirPlaneObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery(
                "select a from AirPlane a " +
                        "where a.flightDateStart " +
                        "= :flightDateStart " +
                        "and a.flightDateEnd " +
                        "= :flightDateEnd");
        query.setParameter("flightDateStart", filterAirPlaneObject.getDateStart());
        query.setParameter("flightDateEnd", filterAirPlaneObject.getDateEnd());
        return query.getResultList();
    }

    @Override
    public List<AirPlane> findAirPlaneWherePriceStartAndPriceEnd(FilterAirPlaneObject filterAirPlaneObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AirPlane> query = criteriaBuilder.createQuery(AirPlane.class);
        Root<AirPlane> root = query.from(AirPlane.class);
        Integer priceStart = filterAirPlaneObject.getPriceStart();
        Integer priceEnd = filterAirPlaneObject.getPriceEnd();
        Predicate predicatePriceStart = criteriaBuilder.equal(root.get(AirPlane_.ticketPrice), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.equal(root.get(AirPlane_.ticketPrice), priceEnd);
        query.where(criteriaBuilder.and(predicatePriceStart, predicatePriceEnd));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<AirPlane> findAirPlaneWhereRouteSEAndDateSE(FilterAirPlaneObject filterAirPlaneObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AirPlane> query = criteriaBuilder.createQuery(AirPlane.class);
        Root<AirPlane> root = query.from(AirPlane.class);
        String routeStart = filterAirPlaneObject.getRouteStart();
        String routeEnd = filterAirPlaneObject.getRouteEnd();
        Date dateStart = filterAirPlaneObject.getDateStart();
        Date dateEnd = filterAirPlaneObject.getDateEnd();
        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(AirPlane_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(AirPlane_.routeEnd), routeEnd);
        Predicate predicateDateStart = criteriaBuilder.equal(root.get(AirPlane_.flightDateStart), dateStart);
        Predicate predicateDateEnd = criteriaBuilder.equal(root.get(AirPlane_.flightDateEnd), dateEnd);
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(criteriaBuilder.and(predicateRouteStart, predicateRouteEnd));
        predicateList.add(criteriaBuilder.and(predicateDateStart, predicateDateEnd));
        query.where(criteriaBuilder.and(predicateList.toArray(Predicate[]::new)));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<AirPlane> findAirPlaneWhereRouteSEAndPriceSE(FilterAirPlaneObject filterAirPlaneObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AirPlane> query = criteriaBuilder.createQuery(AirPlane.class);
        Root<AirPlane> root = query.from(AirPlane.class);
        String routeStart = filterAirPlaneObject.getRouteStart();
        String routeEnd = filterAirPlaneObject.getRouteEnd();
        Integer priceStart = filterAirPlaneObject.getPriceStart();
        Integer priceEnd = filterAirPlaneObject.getPriceEnd();
        Predicate predicatePriceStart = criteriaBuilder.equal(root.get(AirPlane_.ticketPrice), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.equal(root.get(AirPlane_.ticketPrice), priceEnd);
        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(AirPlane_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(AirPlane_.routeEnd), routeEnd);
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(criteriaBuilder.and(predicateRouteStart, predicateRouteEnd));
        predicateList.add(criteriaBuilder.and(predicatePriceStart, predicatePriceEnd));
        query.where(criteriaBuilder.and(predicateList.toArray(Predicate[]::new)));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<AirPlane> findAirPlaneWhereDateSEAndPriceSE(FilterAirPlaneObject filterAirPlaneObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AirPlane> query = criteriaBuilder.createQuery(AirPlane.class);
        Root<AirPlane> root = query.from(AirPlane.class);
        Date dateStart = filterAirPlaneObject.getDateStart();
        Date dateEnd = filterAirPlaneObject.getDateEnd();
        Integer priceStart = filterAirPlaneObject.getPriceStart();
        Integer priceEnd = filterAirPlaneObject.getPriceEnd();
        Predicate predicatePriceStart = criteriaBuilder.equal(root.get(AirPlane_.ticketPrice), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.equal(root.get(AirPlane_.ticketPrice), priceEnd);
        Predicate predicateDateStart = criteriaBuilder.equal(root.get(AirPlane_.flightDateStart), dateStart);
        Predicate predicateDateEnd = criteriaBuilder.equal(root.get(AirPlane_.flightDateEnd), dateEnd);
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(criteriaBuilder.and(predicateDateStart, predicateDateEnd));
        predicateList.add(criteriaBuilder.and(predicatePriceStart, predicatePriceEnd));
        query.where(criteriaBuilder.and(predicateList.toArray(Predicate[]::new)));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<AirPlane> findAirPlaneWhereRouteSEAndDateSEAndPriceSE(FilterAirPlaneObject filterAirPlaneObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AirPlane> query = criteriaBuilder.createQuery(AirPlane.class);
        Root<AirPlane> root = query.from(AirPlane.class);
        String routeStart = filterAirPlaneObject.getRouteStart();
        String routeEnd = filterAirPlaneObject.getRouteEnd();
        Date dateStart = filterAirPlaneObject.getDateStart();
        Date dateEnd = filterAirPlaneObject.getDateEnd();
        Integer priceStart = filterAirPlaneObject.getPriceStart();
        Integer priceEnd = filterAirPlaneObject.getPriceEnd();
        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(AirPlane_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(AirPlane_.routeEnd), routeEnd);
        Predicate predicateDateStart = criteriaBuilder.equal(root.get(AirPlane_.flightDateStart), dateStart);
        Predicate predicateDateEnd = criteriaBuilder.equal(root.get(AirPlane_.flightDateEnd), dateEnd);
        Predicate predicatePriceStart = criteriaBuilder.equal(root.get(AirPlane_.ticketPrice), priceStart);
        Predicate predicatePriceEnd = criteriaBuilder.equal(root.get(AirPlane_.ticketPrice), priceEnd);
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(criteriaBuilder.and(predicateRouteStart, predicateRouteEnd));
        predicateList.add(criteriaBuilder.and(predicateDateStart, predicateDateEnd));
        predicateList.add(criteriaBuilder.and(predicatePriceStart, predicatePriceEnd));
        query.where(criteriaBuilder.and(predicateList.toArray(Predicate[]::new)));
        return entityManager.createQuery(query).getResultList();
    }
}