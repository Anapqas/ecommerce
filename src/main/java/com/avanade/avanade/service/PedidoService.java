package com.avanade.avanade.service;

import com.avanade.avanade.dto.OrderItensDTO;
import com.avanade.avanade.dto.OrderDTO;
import com.avanade.avanade.entity.OrderItem;
import com.avanade.avanade.entity.Order;
import com.avanade.avanade.entity.Product;
import com.avanade.avanade.entity.User;
import com.avanade.avanade.repository.ItemPedidoRepository;
import com.avanade.avanade.repository.PedidoRepository;
import com.avanade.avanade.repository.ProductRepository;
import com.avanade.avanade.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {
    @Autowired
    private PedidoRepository repository;
    @Autowired
    private ItemPedidoRepository repositoryItem;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ResponseEntity<Void> create(OrderDTO dto) throws Exception {
        Optional<User> user = userRepository.findById(dto.user());
        if (user.isPresent()){
            Order order = new Order(user.get(), dto.dateTime());
            order = this.repository.save(order);
            for (OrderItensDTO itemDto : dto.orderItems()){
                Optional<Product> product = productRepository.findById(itemDto.product());
                OrderItem item = new OrderItem(order, product.orElseThrow(), itemDto.quantity(), itemDto.price());
                item = this.repositoryItem.save(item);
                //itens.add(item.dto());
            }
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("order/{id}").buildAndExpand(order.getId()).toUri();
            return ResponseEntity.created(uri).build();

        } else{
            throw new Exception("Exception message provisória");
        }

    }

}
