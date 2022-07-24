package org.example.service.models.modif;

import org.example.dao.models.StatusDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.Status;
import org.example.model.entity.UserOrder;
import org.example.service.models.api.UserOrderService;
import org.example.service.modif.StatusServiceImplModif;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class StatusServiceImplModifTest {
    @Mock
    StatusDAO statusDAO;
    @Mock
    UserOrderService userOrderService;

    @InjectMocks
    StatusServiceImplModif statusServiceImplModif;


    @Test
    public void whenCreate_thenReturnEntity() {
        UserOrder userOrder = UserOrder.builder()
                .id(1L)
                .build();
        List<UserOrder> userOrderList = List.of(userOrder);
        Status GIVEN = Status.builder()
                .id(1L)
                .status("ORDERED")
                .userOrderList(userOrderList)
                .build();
        Status ANSWER = Status.builder()
                .id(1L)
                .status("ORDERED")
                .userOrderList(userOrderList)
                .build();
        Status EXPECTED = Status.builder()
                .id(1L)
                .status("ORDERED")
                .userOrderList(userOrderList)
                .build();
        Mockito.when(statusDAO.save(GIVEN)).thenReturn(ANSWER);
        Status ACTUAL = statusServiceImplModif.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(statusDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        Status GIVEN = Status.builder()
                .id(1L)
                .status(null)
                .build();
        assertThrows(ErrorInvalidData.class, () -> statusServiceImplModif.create(GIVEN));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        UserOrder userOrder = UserOrder.builder()
                .id(1L)
                .build();
        List<UserOrder> userOrderList = List.of(userOrder);
        Status GIVEN = Status.builder()
                .id(1L)
                .status("ORDERED")
                .userOrderList(userOrderList)
                .build();
        Status ANSWER = Status.builder()
                .id(1L)
                .status("ORDERED")
                .userOrderList(userOrderList)
                .build();
        Status EXPECTED = Status.builder()
                .id(1L)
                .status("ORDERED")
                .userOrderList(userOrderList)
                .build();
        Mockito.when(statusDAO.save(GIVEN)).thenReturn(ANSWER);
        Status ACTUAL = statusServiceImplModif.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(statusDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        Status GIVEN = Status.builder()
                .id(1L)
                .status(null)
                .build();
        assertThrows(ErrorInvalidData.class, () -> statusServiceImplModif.update(GIVEN));
    }
}