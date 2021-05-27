package com.rsa.resturantapi.dao;

import com.rsa.resturantapi.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemRepo extends JpaRepository<ItemEntity,Long> {
    @Override
    List<ItemEntity> findAll();
}
