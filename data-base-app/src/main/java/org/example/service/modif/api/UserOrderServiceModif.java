package org.example.service.modif.api;

import org.example.model.entity.UserOrder;

public interface UserOrderServiceModif {

    UserOrder create(UserOrder userOrder);

    UserOrder update(UserOrder userOrder);
}

