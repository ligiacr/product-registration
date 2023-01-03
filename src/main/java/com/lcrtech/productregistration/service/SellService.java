package com.lcrtech.productregistration.service;

import com.lcrtech.productregistration.model.Sell;
import com.lcrtech.productregistration.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellService {

    @Autowired
    private SellRepository sellRepository;

    public List<Sell> listSell() {
        return sellRepository.findAll();
    }

    public Sell saveSell(Sell sell) {

        return sellRepository.save(sell);
    }
}
