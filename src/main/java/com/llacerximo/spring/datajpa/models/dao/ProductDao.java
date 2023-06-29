package com.llacerximo.spring.datajpa.models.dao;

import com.llacerximo.spring.datajpa.models.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductDao extends CrudRepository<Product, Long> {

    @Query("select p from Product p where p.name like %?1%")
    List<Product> findByName(String term);
}
