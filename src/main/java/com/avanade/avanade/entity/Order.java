package com.avanade.avanade.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> itens = new HashSet<>();

    public Order(User user, LocalDateTime dateTime ){
        this.dateTime = dateTime;
        this.user = user;

    }
/*
    public PedidoDTO dto(){
        return new PedidoDTO( this.user.getId(), this.dateTime, this.itens );
    }*/


}
