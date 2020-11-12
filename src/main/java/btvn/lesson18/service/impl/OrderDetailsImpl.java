package btvn.lesson18.service.impl;

import btvn.lesson18.entities.Order_details;
import btvn.lesson18.repository.OrderDetailRepository;
import btvn.lesson18.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsImpl implements OrderDetailsService {

    @Autowired
    OrderDetailRepository orRepo;

    @Override
    public void insertOrderDetails(Order_details o) {
        orRepo.save(o);
    }
}
