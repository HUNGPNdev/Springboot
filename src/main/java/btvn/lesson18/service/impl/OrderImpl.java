package btvn.lesson18.service.impl;

import btvn.lesson18.entities.OrderEntity;
import btvn.lesson18.repository.OrderRepository;
import btvn.lesson18.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void insertOrder(OrderEntity o) {
        orderRepository.save(o);
    }

    @Override
    public List<OrderEntity> getAllOrder() {
        return orderRepository.findAll();
    }
}
