package com.nazar.micro.organisation.repository;

import com.nazar.micro.organisation.model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrganisationRepository extends JpaRepository<Organisation,Long> {
    @Override
    <S extends Organisation> S save(S s);

    @Override
    List<Organisation> findAll();

    @Override
    Optional<Organisation> findById(Long aLong);
}
