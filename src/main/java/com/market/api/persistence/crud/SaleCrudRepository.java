package com.market.api.persistence.crud;

import com.market.api.persistence.entity.Sale;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SaleCrudRepository extends CrudRepository<Sale, Integer> {

    Optional<List<Sale>> findByClientId(String clientId);
}
