package com.app.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.shoppingcart.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
