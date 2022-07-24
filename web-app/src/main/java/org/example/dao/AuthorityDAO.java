package org.example.dao;

import org.example.model.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityDAO extends JpaRepository<Authorities, Long> {
}
