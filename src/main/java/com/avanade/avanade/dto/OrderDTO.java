package com.avanade.avanade.dto;

import java.time.LocalDateTime;
import java.util.Set;


public record OrderDTO(Long user
                       , LocalDateTime dateTime
                       , Set<OrderItensDTO> orderItems){
}

