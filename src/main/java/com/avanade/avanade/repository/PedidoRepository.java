package com.avanade.avanade.repository;

import com.avanade.avanade.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Order, Long> {

}
