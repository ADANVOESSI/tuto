package com.highfive.tuto.service;

import org.springframework.stereotype.Service;
import com.highfive.tuto.domain.Sale;
import com.highfive.tuto.repositories.SaleRepository;

@Service
public class SaleService extends CrudService<Sale, Long>{
    
    
    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository){
        super(saleRepository);
        this.saleRepository = saleRepository;
    }

}
