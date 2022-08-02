package org.example.service.models.authorities;

import org.example.model.Authorities;

import java.util.List;

public interface AuthoritiesService {
    List<Authorities> readAll();

    Authorities readById(Long id);

    List<Authorities> readAllByIds(List<Long> ids);

    Authorities create(Authorities authorities);

    Authorities update(Authorities authorities);

    Authorities deleteById(Long id);

    List<Authorities> deleteAllByIds(List<Long> ids);
}
