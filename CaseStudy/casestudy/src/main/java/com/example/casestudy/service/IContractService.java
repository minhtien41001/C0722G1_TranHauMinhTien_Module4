package com.example.casestudy.service;

import com.example.casestudy.dto.IContractDto;
import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.repository.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {

    void save(Contract contract);

    List<IContractDto> findAllDto();

    Page<IContractDto> findAllDto(Pageable pageable);
}
