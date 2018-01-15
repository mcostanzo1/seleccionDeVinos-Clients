package com.dp3.dao;


import com.dp3.domain.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

}