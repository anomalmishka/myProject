package org.example.service.models;

import org.assertj.core.api.Assertions;
import org.example.dao.models.BankCardDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.BankCard;
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
class BankCardServiceImplTest {
    @Mock
    BankCardDAO bankCardDAO;

    @InjectMocks
    BankCardServiceImpl bankCardService;

    @Test
    public void whenCreate_thenReturnEntity() {
        BankCard GIVEN = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        BankCard ANSWER = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        BankCard EXPECTED = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        Mockito.when(bankCardDAO.save(GIVEN)).thenReturn(ANSWER);
        BankCard ACTUAL = bankCardService.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(bankCardDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        BankCard GIVEN = BankCard.builder()
                .id(1L)
                .cardNumber(null)
                .build();
        assertThrows(ErrorInvalidData.class, () -> bankCardService.create(GIVEN));
    }

    @Test
    public void whenReadAll_thenReturnEntityList() {
        BankCard ANSWER = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        List<BankCard> ANSWER_LIST = List.of(ANSWER);
        BankCard EXPECTED = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        List<BankCard> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(bankCardDAO.findAll()).thenReturn(ANSWER_LIST);
        List<BankCard> ACTUAL_LIST = bankCardService.readAll();
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(bankCardDAO, Mockito.times(1))
                .findAll();
    }

    @Test
    void whenReadAll_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        BankCard ANSWER = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        List<BankCard> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(bankCardDAO.findAll()).thenReturn(ANSWER_LIST);
        Assertions.assertThat(bankCardService.readAll()).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenReadById_thenReturnEntity() {
        Long GIVEN_ID = 1L;
        BankCard ANSWER = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        BankCard EXPECTED = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        Mockito.when(bankCardDAO.findById(GIVEN_ID)).thenReturn(Optional.ofNullable(ANSWER));
        BankCard ACTUAL = bankCardService.readById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(bankCardDAO, Mockito.times(1))
                .findById(GIVEN_ID);
    }

    @Test
    void whenReadById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(bankCardDAO.findById(GIVEN_ID)).thenReturn(Optional.empty());
        assertThrows(ErrorDataNotFound.class, () -> bankCardService.readById(GIVEN_ID));
    }

    @Test
    public void whenReadAllById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        BankCard ANSWER = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        List<BankCard> ANSWER_LIST = List.of(ANSWER);
        BankCard EXPECTED = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        List<BankCard> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(bankCardDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        List<BankCard> ACTUAL_LIST = bankCardService.readAllByIds(GIVEN_ID_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(bankCardDAO, Mockito.times(1))
                .findAllById(GIVEN_ID_LIST);
    }

    @Test
    void whenReadAllById_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        BankCard ANSWER = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        List<BankCard> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(bankCardDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        Assertions.assertThat(bankCardService.readAllByIds(GIVEN_ID_LIST)).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenDeleteById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        BankCard ANSWER = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        BankCard EXPECTED = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        Mockito.when(bankCardDAO.findById(GIVEN_ID)).thenReturn(Optional.of(ANSWER));
        BankCard ACTUAL = bankCardService.deleteById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(bankCardDAO, Mockito.times(1))
                .deleteById(GIVEN_ID);
    }

    @Test
    void whenDeleteById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        assertThrows(ErrorDataNotFound.class, () -> bankCardService.deleteById(GIVEN_ID));
    }

    @Test
    public void whenDeleteAllByIds_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        BankCard ANSWER = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        List<BankCard> ANSWER_LIST = List.of(ANSWER);
        BankCard EXPECTED = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        List<BankCard> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(bankCardDAO.findAllById(GIVEN_LIST)).thenReturn(ANSWER_LIST);
        Mockito.doNothing().when(bankCardDAO).deleteAllById(GIVEN_LIST);
        List<BankCard> ACTUAL_LIST = bankCardService.deleteAllByIds(GIVEN_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(bankCardDAO, Mockito.times(1))
                .deleteAllById(GIVEN_LIST);
    }

    @Test
    void whenDeleteAllByIds_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Mockito.doThrow(ErrorDataNotFound.class).when(bankCardDAO).deleteAllById(GIVEN_LIST);
        assertThrows(ErrorDataNotFound.class, () -> bankCardService.deleteAllByIds(GIVEN_LIST));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        BankCard GIVEN = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        BankCard ANSWER = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        BankCard EXPECTED = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        Mockito.when(bankCardDAO.save(GIVEN)).thenReturn(ANSWER);
        BankCard ACTUAL = bankCardService.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(bankCardDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        BankCard GIVEN = BankCard.builder()
                .id(1L)
                .cardNumber(null)
                .build();
        assertThrows(ErrorInvalidData.class, () -> bankCardService.update(GIVEN));
    }
}