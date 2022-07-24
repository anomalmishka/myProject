package org.example.service.models;

import org.assertj.core.api.Assertions;
import org.example.dao.models.UserOrderDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.UserOrder;
import org.example.service.models.UserOrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserOrderServiceImplTest {
    @Mock
    UserOrderDAO userOrderDAO;

    @InjectMocks
    UserOrderServiceImpl userOrderService;

    @Test
    public void whenCreate_thenReturnEntity() {
        UserOrder GIVEN = UserOrder.builder()
                .id(1L)
                .build();
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .build();
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .build();
        Mockito.when(userOrderDAO.save(GIVEN)).thenReturn(ANSWER);
        UserOrder ACTUAL = userOrderService.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userOrderDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        UserOrder GIVEN = UserOrder.builder()
                .id(null)
                .build();
        Mockito.when(userOrderDAO.save(GIVEN)).thenThrow(ErrorInvalidData.class);
        assertThrows(ErrorInvalidData.class, () -> userOrderService.create(GIVEN));
    }

    @Test
    public void whenReadAll_thenReturnEntityList() {
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .build();
        List<UserOrder> ANSWER_LIST = List.of(ANSWER);
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .build();
        List<UserOrder> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(userOrderDAO.findAll()).thenReturn(ANSWER_LIST);
        List<UserOrder> ACTUAL_LIST = userOrderService.readAll();
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(userOrderDAO, Mockito.times(1))
                .findAll();
    }

    @Test
    void whenReadAll_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .build();
        List<UserOrder> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(userOrderDAO.findAll()).thenReturn(ANSWER_LIST);
        Assertions.assertThat(userOrderService.readAll()).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenReadById_thenReturnEntity() {
        Long GIVEN_ID = 1L;
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .build();
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .build();
        Mockito.when(userOrderDAO.findById(GIVEN_ID)).thenReturn(Optional.ofNullable(ANSWER));
        UserOrder ACTUAL = userOrderService.readById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userOrderDAO, Mockito.times(1))
                .findById(GIVEN_ID);
    }

    @Test
    void whenReadById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(userOrderDAO.findById(GIVEN_ID)).thenReturn(Optional.empty());
        assertThrows(ErrorDataNotFound.class, () -> userOrderService.readById(GIVEN_ID));
    }

    @Test
    public void whenReadAllById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .build();
        List<UserOrder> ANSWER_LIST = List.of(ANSWER);
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .build();
        List<UserOrder> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(userOrderDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        List<UserOrder> ACTUAL_LIST = userOrderService.readAllByIds(GIVEN_ID_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(userOrderDAO, Mockito.times(1))
                .findAllById(GIVEN_ID_LIST);
    }

    @Test
    void whenReadAllById_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .build();
        List<UserOrder> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(userOrderDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        Assertions.assertThat(userOrderService.readAllByIds(GIVEN_ID_LIST)).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenDeleteById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .build();
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .build();
        Mockito.when(userOrderDAO.findById(GIVEN_ID)).thenReturn(Optional.of(ANSWER));
        UserOrder ACTUAL = userOrderService.deleteById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userOrderDAO, Mockito.times(1))
                .deleteById(GIVEN_ID);
    }

    @Test
    void whenDeleteById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        assertThrows(ErrorDataNotFound.class, () -> userOrderService.deleteById(GIVEN_ID));
    }

    @Test
    public void whenDeleteAllByIds_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .build();
        List<UserOrder> ANSWER_LIST = List.of(ANSWER);
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .build();
        List<UserOrder> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(userOrderDAO.findAllById(GIVEN_LIST)).thenReturn(ANSWER_LIST);
        Mockito.doNothing().when(userOrderDAO).deleteAllById(GIVEN_LIST);
        List<UserOrder> ACTUAL_LIST = userOrderService.deleteAllByIds(GIVEN_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(userOrderDAO, Mockito.times(1))
                .deleteAllById(GIVEN_LIST);
    }

    @Test
    void whenDeleteAllByIds_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Mockito.doThrow(ErrorDataNotFound.class).when(userOrderDAO).deleteAllById(GIVEN_LIST);
        assertThrows(ErrorDataNotFound.class, () -> userOrderService.deleteAllByIds(GIVEN_LIST));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        UserOrder GIVEN = UserOrder.builder()
                .id(1L)
                .build();
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .build();
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .build();
        Mockito.when(userOrderDAO.save(GIVEN)).thenReturn(ANSWER);
        UserOrder ACTUAL = userOrderService.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userOrderDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        UserOrder GIVEN = UserOrder.builder()
                .id(null)
                .build();
        assertThrows(ErrorInvalidData.class, () -> userOrderService.update(GIVEN));
    }
}