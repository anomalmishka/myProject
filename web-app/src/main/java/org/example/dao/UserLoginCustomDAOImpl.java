package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.model.UserLogin;
import org.example.model.UserLogin_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Repository
@Transactional
public class UserLoginCustomDAOImpl implements UserLoginCustomDAO {
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public List<UserLogin> findUserWhereUsername(String username) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserLogin> query = criteriaBuilder.createQuery(UserLogin.class);
        Root<UserLogin> root = query.from(UserLogin.class);
        Predicate predicate = criteriaBuilder.equal(root.get(UserLogin_.username), username);
        query.where(predicate);
        List<UserLogin> resultList = entityManager.createQuery(query).getResultList();
        entityManager.close();
        return resultList;
    }
}
