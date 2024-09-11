package com.avanade.avanade.controller;

import com.avanade.avanade.dto.OrderDTO;
import com.avanade.avanade.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class PedidoController {

    private PedidoService service;

    public PedidoController (PedidoService service){ this.service = service;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public /* PedidoDTO */  ResponseEntity<Void> create(@RequestBody OrderDTO body) throws Exception {
        /*         return ResponseEntity.status(HttpStatus.CREATED).body("created " + body); */
        return service.create(body);
    }

}
