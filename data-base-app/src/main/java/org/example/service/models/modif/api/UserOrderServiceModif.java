package org.example.service.models.modif.api;

import org.example.model.entity.UserOrder;

public interface UserOrderServiceModif {

    UserOrder create(UserOrder userOrder);

    UserOrder update(UserOrder userOrder);
}

