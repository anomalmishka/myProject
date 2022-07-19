package org.example.service.models;
import lombok.RequiredArgsConstructor;
import org.example.dao.models.BankCardDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.BankCard;
import org.example.service.models.api.BankCardService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class BankCardServiceImpl implements BankCardService {

    private final BankCardDAO bankCardDAO;

    @Override
    public BankCard create(BankCard bankCard) {
        if (bankCard.getCardType() != null) {
            return bankCardDAO.save(bankCard);
        } else {
            throw new ErrorInvalidData("CardType must not be null");
        }
    }

    @Override
    public List<BankCard> readAll() {
        return StreamSupport
                .stream(bankCardDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public BankCard readById(Long id) {
        return bankCardDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<BankCard> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(bankCardDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public BankCard deleteById(Long id) {
        BankCard deleteEntity = readById(id);
        bankCardDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<BankCard> deleteAllByIds(List<Long> ids) {
        List<BankCard> deleteEntities = readAllByIds(ids);
        bankCardDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public BankCard update(BankCard bankCard) {
        if (bankCard.getCardType() != null) {
            return bankCardDAO.save(bankCard);
        } else {
            throw new ErrorInvalidData("CardType must not be null");
        }
    }
}
