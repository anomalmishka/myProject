package org.example.service.models;
import lombok.RequiredArgsConstructor;
import org.example.dao.models.AirCompanyDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.AirCompany;
import org.example.service.api.AirCompanyService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class AirCompanyServiceImpl implements AirCompanyService {

    private final AirCompanyDAO airCompanyDAO;

    @Override
    public AirCompany create(AirCompany airCompany) {
        if (airCompany.getNameCompany() != null) {
            return airCompanyDAO.save(airCompany);
        } else {
            throw new ErrorInvalidData("NameCompany must not be null");
        }
    }

    @Override
    public List<AirCompany> readAll() {
        return StreamSupport
                .stream(airCompanyDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public AirCompany readById(Long id) {
        return airCompanyDAO.findById(id).orElseThrow(() -> {
            throw new ErrorDataNotFound(String.format("This id = %d not found!", id));
        });
    }

    @Override
    public List<AirCompany> readAllByIds(List<Long> ids) {
        return StreamSupport
                .stream(airCompanyDAO.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public AirCompany deleteById(Long id) {
        AirCompany deleteEntity = airCompanyDAO.findById(id).orElse(null);
        airCompanyDAO.deleteById(id);
        return deleteEntity;
    }

    @Override
    public List<AirCompany> deleteAllByIds(List<Long> ids) {
        List<AirCompany> deleteEntities = readAllByIds(ids);
        airCompanyDAO.deleteAllById(ids);
        return deleteEntities;
    }

    @Override
    public AirCompany update(AirCompany airCompany) {
        if (airCompany.getNameCompany() != null) {
            return airCompanyDAO.save(airCompany);
        } else {
            throw new ErrorInvalidData("NameCompany must not be null");
        }
    }
}
