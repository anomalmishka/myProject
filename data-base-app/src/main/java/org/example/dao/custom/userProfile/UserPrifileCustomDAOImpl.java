package org.example.dao.custom.userProfile;

import lombok.RequiredArgsConstructor;
import org.example.model.UserProfile;
import org.example.model.UserProfile_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;

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
        String name = userProfile.getUsername();
        String lastname = userProfile.getLastname();
        String email = userProfile.getEmail();
        Predicate predicateName = criteriaBuilder.equal(root.get(UserProfile_.username), name);
        Predicate predicateLastname = criteriaBuilder.equal(root.get(UserProfile_.lastname), lastname);
        Predicate predicateEmail = criteriaBuilder.equal(root.get(UserProfile_.email), email);
        Predicate predicateNameLastname = criteriaBuilder.and(predicateName, predicateLastname);
        Predicate predicateNameLastnameEmail = criteriaBuilder.and(predicateNameLastname, predicateEmail);
        query.where(predicateNameLastnameEmail);
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public UserProfile findWhereUserId(Long userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserProfile> query = criteriaBuilder.createQuery(UserProfile.class);
        Root<UserProfile> root = query.from(UserProfile.class);
        Predicate predicateUserID = criteriaBuilder.equal(root.get(UserProfile_.userId), userId);
        query.where(predicateUserID);
        return entityManager.createQuery(query).getSingleResult();
    }
}
