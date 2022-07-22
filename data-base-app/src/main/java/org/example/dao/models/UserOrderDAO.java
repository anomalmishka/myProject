package org.example.dao.models;

import org.example.model.entity.UserOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderDAO extends CrudRepository<UserOrder, Long> {
}
