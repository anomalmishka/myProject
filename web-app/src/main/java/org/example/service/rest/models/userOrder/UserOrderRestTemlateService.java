package org.example.service.rest.models.userOrder;

import org.example.dto.models.modif.UserOrderDTOModif;
import org.example.dto.models.modif.UserOrderDTOtoSave;

import java.util.List;

public interface UserOrderRestTemlateService {
    List<UserOrderDTOModif> readAll();

    UserOrderDTOModif readById(Long id);

    List<UserOrderDTOModif> readAllByIds(List<Long> ids);

    UserOrderDTOModif create(UserOrderDTOtoSave userOrderDTOtoSave);

    UserOrderDTOModif update(UserOrderDTOModif userOrderDTOModif);

    UserOrderDTOModif deleteById(Long id);

    List<UserOrderDTOModif> deleteAllByIds(List<Long> ids);
}
