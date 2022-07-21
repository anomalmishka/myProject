package org.example.service.api;

import org.example.model.entity.UserOrder;

import java.util.List;

public interface UserOrderService {

    UserOrder create(UserOrder userOrder);

    List<UserOrder> readAll();

    UserOrder readById(Long id);

    List<UserOrder> readAllByIds(List<Long> ids);

    UserOrder deleteById(Long id);

    List<UserOrder> deleteAllByIds(List<Long> ids);

    UserOrder update(UserOrder userOrder);
}

