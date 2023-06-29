package com.llacerximo.spring.datajpa.models.service;

import com.llacerximo.spring.datajpa.models.entity.Client;
import com.llacerximo.spring.datajpa.models.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {
    List<Client> getAll();
    Page<Client> getAll(Pageable pageable);
    void insert(Client client);
    Client getById(Long id);
    void delete(Long id);
    List<Product> findByName(String term);
}
