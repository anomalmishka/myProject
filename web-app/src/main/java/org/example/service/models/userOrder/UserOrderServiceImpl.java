package org.example.service.models.userOrder;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.UserOrderDTOModif;
import org.example.dto.models.modif.UserOrderDTOtoSave;
import org.example.service.rest.models.userOrder.UserOrderRestTemlateService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserOrderServiceImpl implements UserOrderService {

    private final UserOrderRestTemlateService userOrderRestTemlateService;


    @Override
    public List<UserOrderDTOModif> readAll() {
        return userOrderRestTemlateService.readAll();
    }

    @Override
    public UserOrderDTOModif readById(Long id) {
        return userOrderRestTemlateService.readById(id);
    }

    @Override
    public List<UserOrderDTOModif> readAllByIds(List<Long> ids) {
        return userOrderRestTemlateService.readAllByIds(ids);
    }

    @Override
    public UserOrderDTOModif create(UserOrderDTOtoSave userOrderDTOtoSave) {
        return userOrderRestTemlateService.create(userOrderDTOtoSave);
    }

    @Override
    public UserOrderDTOModif update(UserOrderDTOModif userOrderDTOModif) {
        return userOrderRestTemlateService.update(userOrderDTOModif);
    }

    @Override
    public UserOrderDTOModif deleteById(Long id) {
        return userOrderRestTemlateService.deleteById(id);
    }

    @Override
    public List<UserOrderDTOModif> deleteAllByIds(List<Long> ids) {
        return userOrderRestTemlateService.deleteAllByIds(ids);
    }
}
