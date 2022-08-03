package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Repository
@Transactional
public class LoginCustomDAOImpl implements LoginCustomDAO {
    private final EntityManagerFactory entityManagerFactory;

//    @Override
//    public UserDetails findUserWhereUsername(String username) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
//        Root<User> root = query.from(User.class);
//        Predicate predicate = criteriaBuilder.equal(root.get(User_.username), username);
//        query.where(predicate);
//        User singleResult = entityManager.createQuery(query).getSingleResult();
//        return new CustomUserPrincipal(singleResult);
//    }
}
