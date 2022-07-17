package org.example.service.interfaces.models;
import org.example.model.entity.BankCard;
import java.util.List;

public interface BankCardService {

    BankCard create(BankCard bankCard);

    List<BankCard> readAll();

    BankCard readById(Long id);

    List<BankCard> readAllByIds(List<Long> ids);

    BankCard deleteById(Long id);

    List<BankCard> deleteAllByIds(List<Long> ids);

    BankCard update(BankCard bankCard);
}

