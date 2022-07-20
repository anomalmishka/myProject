package org.example.service.models;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.OrderDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.UserOrder;
import org.example.service.api.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO;

    @Override
    public UserOrder create(UserOrder userOrder) {
        if (userOrder.getIsActive() != null) {
            return orderDAO.save(userOrder);
        } else {
            throw new ErrorInvalidData("Act must not be null");
        }
    }

    @Override
    public List<UserOrder> readAll() {
        return StreamSupport
                .stream(orderDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public UserOrder readById(Long id) {
        return orderDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<UserOrder> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(orderDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public UserOrder deleteById(Long id) {
        UserOrder deleteEntity = readById(id);
        orderDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<UserOrder> deleteAllByIds(List<Long> ids) {
        List<UserOrder> deleteEntities = readAllByIds(ids);
        orderDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public UserOrder update(UserOrder userOrder) {
        if (userOrder.getIsActive() != null) {
            return orderDAO.save(userOrder);
        } else {
            throw new ErrorInvalidData("Act must not be null");
        }
    }
}
