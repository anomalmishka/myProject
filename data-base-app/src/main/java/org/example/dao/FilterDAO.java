package org.example.dao;

import org.example.dto.api.FilterObject;
import org.example.model.AirPlane;
import org.example.model.AirPlane_;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class FilterDAO implements FilterCustomDao {

    public FilterDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<AirPlane> findAirPlaneWhereRouteStartAndRouteEnd(FilterObject filterObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AirPlane> query = criteriaBuilder.createQuery(AirPlane.class);
        Root<AirPlane> root = query.from(AirPlane.class);
        String routeStart = filterObject.getRouteStart();
        String routeEnd = filterObject.getRouteEnd();
        Predicate predicateRouteStart = criteriaBuilder.equal(root.get(AirPlane_.routeStart), routeStart);
        Predicate predicateRouteEnd = criteriaBuilder.equal(root.get(AirPlane_.routeEnd), routeEnd);
        query.where(criteriaBuilder.and(predicateRouteStart, predicateRouteEnd));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<AirPlane> findAirPlaneWhereDateStartAndDateEnd(FilterObject filterObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery(
                "select a from air_plane a " +
                        "where a.route_start " +
                        "= :route_start " +
                        "and a.route_end " +
                        "= :route_end");
        query.setParameter("route_start", filterObject.getRouteStart());
        query.setParameter("route_end", filterObject.getRouteEnd());
        return query.getResultList();
    }

    @Override
    public List<AirPlane> findAirPlaneWherePriceStartAndPriceEnd(FilterObject filterObject) {
        return null;
    }
}