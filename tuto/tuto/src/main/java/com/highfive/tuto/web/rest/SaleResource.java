package com.highfive.tuto.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.highfive.tuto.service.SaleService;
import com.highfive.tuto.domain.Sale;


@RestController
@RequestMapping("/sales")

public class SaleResource extends CrudResource<Sale, Long> {
    
    private SaleService saleService;
    public SaleResource(SaleService saleService) {
        super(saleService);
        this.saleService = saleService;
    }
}
