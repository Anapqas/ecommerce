package com.avanade.avanade.repository;

import com.avanade.avanade.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<OrderItem, Long> {

}
