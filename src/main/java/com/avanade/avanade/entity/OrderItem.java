package com.avanade.avanade.entity;

import com.avanade.avanade.dto.OrderItensDTO;
import jakarta.persistence.*;
import com.avanade.avanade.entity.pk.OrderItemPK;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_item")
public class OrderItem {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;

    private Double price;
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        super();
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }
    public Double getSubTotal() {
        return price * quantity;
    }
/*
    public OrderItensDTO dto(){
        return new OrderItensDTO(this.id, this.order.dto(), this.produto.dto(), this.quantidade);
    }*/
}
