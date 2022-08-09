package org.example.dao.custom.seat;

import lombok.RequiredArgsConstructor;
import org.example.model.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Repository
@Transactional
public class SeatCustomDAOImpl implements SeatCustomDAO {
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<Seat> findSeatWhereAirPlaneId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Seat> query = criteriaBuilder.createQuery(Seat.class);
        Root<Seat> root = query.from(Seat.class);
        Join<Seat, AirPlane> airPlaneJoin = root.join(Seat_.airPlane, JoinType.LEFT);
        Predicate predicate = criteriaBuilder.equal(airPlaneJoin.get(AirPlane_.id), id);
        query.where(predicate).distinct(true);
        List<Seat> resultList = entityManager.createQuery(query).getResultList();
        entityManager.close();
        return resultList;
    }
}
