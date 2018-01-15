package com.dp3.dao;

import com.dp3.domain.PriceList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends MongoRepository<PriceList, String> {

}