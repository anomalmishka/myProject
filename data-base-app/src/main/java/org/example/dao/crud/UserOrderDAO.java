package org.example.dao.crud;

import org.example.model.UserOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderDAO extends CrudRepository<UserOrder, Long> {
}
