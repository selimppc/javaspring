package com.avatar.user.tax.repository;

import com.avatar.user.tax.entity.Tax;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface TaxRepository extends CrudRepository<Tax, Integer> {

    Optional<Tax> findByFirstName();
}
