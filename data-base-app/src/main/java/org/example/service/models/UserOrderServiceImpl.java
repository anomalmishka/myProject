package org.example.service.models;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.UserOrderDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.UserOrder;
import org.example.service.api.UserOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class UserOrderServiceImpl implements UserOrderService {
    private final UserOrderDAO userOrderDAO;

    @Override
    public UserOrder create(UserOrder userOrder) {
            return userOrderDAO.save(userOrder);
    }

    @Override
    public List<UserOrder> readAll() {
        return StreamSupport
                .stream(userOrderDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public UserOrder readById(Long id) {
        return userOrderDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<UserOrder> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(userOrderDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public UserOrder deleteById(Long id) {
        UserOrder deleteEntity = readById(id);
        userOrderDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<UserOrder> deleteAllByIds(List<Long> ids) {
        List<UserOrder> deleteEntities = readAllByIds(ids);
        userOrderDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public UserOrder update(UserOrder userOrder) {
        if (userOrder.getId() != null) {
            return userOrderDAO.save(userOrder);
        } else {
            throw new ErrorInvalidData("Id must not be null");
        }
    }
}
