package org.example.service.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.StatusDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.Status;
import org.example.model.entity.UserOrder;
import org.example.service.api.UserOrderService;
import org.example.service.models.modif.api.StatusServiceModif;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StatusServiceImplModif implements StatusServiceModif {
    private final StatusDAO statusDAO;
    private final UserOrderService userOrderService;

    @Override
    public Status create(Status status) {
        return statusDAO.save(setForgetValueOnId(status));
    }


    @Override
    public Status update(Status status) {
        return statusDAO.save(setForgetValueOnId(status));
    }

    private Status setForgetValueOnId(Status status) {
        if (status.getStatus() != null) {
            List<Long> userOrderIdList = status.getUserOrderList().stream().map(UserOrder::getId).collect(Collectors.toList());
            List<UserOrder> userOrderList = userOrderService.readAllByIds(userOrderIdList);
            status.setUserOrderList(userOrderList);
            return status;
        } else {
            throw new ErrorInvalidData("Status must not be null");
        }
    }
}
