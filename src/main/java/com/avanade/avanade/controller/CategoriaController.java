package com.avanade.avanade.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
/* import org.springframework.http.ResponseEntity; */
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.avanade.avanade.dto.CategoriaDTO;
import com.avanade.avanade.service.CategoryService;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoryService service;
    public CategoriaController(CategoryService service){

        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public /* ResponseEntity<String> */ CategoriaDTO create(@RequestBody CategoriaDTO body) {
/*         return ResponseEntity.status(HttpStatus.CREATED).body("created " + body); */
        return service.create(body);
    }

    @GetMapping("/{id}")
    public CategoriaDTO getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping("filter")
    public List<CategoriaDTO> getAll(
        @RequestBody CategoriaDTO body) {
        return service.getAll(body);
    }

    @PutMapping("/{id}")
    public CategoriaDTO edit(@RequestBody CategoriaDTO body, @PathVariable Long id) {
        return service.edit(body, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}