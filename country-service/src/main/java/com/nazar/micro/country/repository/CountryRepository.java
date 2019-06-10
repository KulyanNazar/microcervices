package com.nazar.micro.country.repository;

import com.nazar.micro.country.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    @Override
    <S extends Country> S save(S s);

    @Override
    Optional<Country> findById(Long aLong);

    @Override
    List<Country> findAll();

    List<Country> findByOrganisationIds(Long id);
}
