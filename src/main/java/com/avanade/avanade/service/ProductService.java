package com.avanade.avanade.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.avanade.avanade.entity.Category;
import com.avanade.avanade.entity.Product;
import com.avanade.avanade.repository.CategoryRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.avanade.avanade.dto.ProductDTO;
import com.avanade.avanade.repository.ProductRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;

/*
    public ProductDTO create(ProductDTO dto) {
        Product categoria = new Product(dto);
        categoria = this.repository.save(categoria);
        return categoria.dto();
    }


    public ProductDTO getOne(Long id) {
        Optional<Product> categoriaOp = this.repository.findById(id);
        return categoriaOp.get().dto();
    }


    public List<ProductDTO> getAll() {
        return this.repository.findAll().stream().map(categoria -> categoria.dto()).toList();
    }

    public ProductDTO edit(ProductDTO dto, Long id) {
        Product categoria = new Product(dto, id);
        categoria = this.repository.save(categoria);
        return categoria.dto();
    }

    public void delete(Long id) {
        this.repository.deleteById(id);

    }*/

    public ResponseEntity<Void> create(ProductDTO request) {
        System.out.println("request.category()" + request.category());
        Optional<Category> category = categoryRepository.findById(request.category());
        Product product = new Product(request, category.orElseThrow());
        product = this.repository.save(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    public ResponseEntity<ProductDTO> getOne(Long id) {
        Optional<Product> ProductOp = this.repository.findById(id);
        return ResponseEntity.ok().body(ProductOp.orElseThrow().toDto());
    }

    public ResponseEntity<List<ProductDTO>> getAll() {
        return ResponseEntity.ok().body(this.repository.findAll().stream().map(Product::toDto).toList());

    }
    public ResponseEntity<ProductDTO> edit(ProductDTO dto, Long id) {
        Optional<Category> category = categoryRepository.findById(dto.category());
        Product Product = new Product(dto, category.orElseThrow(), id);
        Product = this.repository.save(Product);
        return ResponseEntity.ok().body(Product.toDto());
    }

    public ResponseEntity<Void> delete(Long id) {
        this.repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
