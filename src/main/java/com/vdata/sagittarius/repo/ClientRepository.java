package com.vdata.sagittarius.repo;

import com.vdata.sagittarius.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
}
