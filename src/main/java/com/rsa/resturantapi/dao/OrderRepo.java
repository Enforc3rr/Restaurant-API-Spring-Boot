package com.rsa.resturantapi.dao;

import com.rsa.resturantapi.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity , Long> {
}
