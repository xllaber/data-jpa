package com.llacerximo.spring.datajpa.models.dao;

import com.llacerximo.spring.datajpa.models.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientDao extends CrudRepository<Client, Long>, PagingAndSortingRepository<Client, Long> {

}
