package com.llacerximo.spring.datajpa.models.service;

import com.llacerximo.spring.datajpa.models.dao.ClientDao;
import com.llacerximo.spring.datajpa.models.dao.ProductDao;
import com.llacerximo.spring.datajpa.models.entity.Client;
import com.llacerximo.spring.datajpa.models.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clientServiceJPA")
public class ClientServiceImpl implements ClientService{

    @Autowired
//    @Qualifier("clientDaoJPA")
    ClientDao clientDao;

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional
    public List<Client> getAll() {
        return (List<Client>) clientDao.findAll();
    }

    @Override
    @Transactional
    public Page<Client> getAll(Pageable pageable) {
        return clientDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void insert(Client client) {
        clientDao.save(client);
    }

    @Override
    @Transactional
    public Client getById(Long id) {
        return clientDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clientDao.deleteById(id);
    }

    @Override
    public List<Product> findByName(String term) {
        return productDao.findByName(term);
    }
}
