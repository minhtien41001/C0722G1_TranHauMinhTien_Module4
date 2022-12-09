package com.example.casestudy.service;

import com.example.casestudy.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerTypeService {

    List<CustomerType> findAll();

}
