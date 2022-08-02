package org.example.dao.custom.userProfile;

import lombok.RequiredArgsConstructor;
import org.example.dao.custom.flightRoute.TimestampdiffExpression;
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
public class UserPrifileCustomDAOImpl implements UserPrifileCustomDAO {
    private final EntityManagerFactory entityManagerFactory;


    @Override
    public UserProfile findWhereNameLastnameEmail(UserProfile userProfile) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserProfile> query = criteriaBuilder.createQuery(UserProfile.class);
        Root<UserProfile> root = query.from(UserProfile.class);
        String name = userProfile.getName();
        String lastname = userProfile.getLastname();
        String email = userProfile.getEmail();
        Predicate predicateName = criteriaBuilder.equal(root.get(UserProfile_.name), name);
        Predicate predicateLastname = criteriaBuilder.equal(root.get(UserProfile_.lastname), lastname);
        Predicate predicateEmail = criteriaBuilder.equal(root.get(UserProfile_.email), email);
        Predicate predicateNameLastname = criteriaBuilder.and(predicateName, predicateLastname);
        Predicate predicateNameLastnameEmail = criteriaBuilder.and(predicateNameLastname, predicateEmail);
        query.where(predicateNameLastnameEmail);
        return entityManager.createQuery(query).getSingleResult();
    }
}
