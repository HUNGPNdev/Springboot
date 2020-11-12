package btvn.lesson18.service;

import btvn.lesson18.entities.OrderEntity;

import java.util.List;

public interface OrderService {
    void insertOrder(OrderEntity o);
    List<OrderEntity> getAllOrder();
}
