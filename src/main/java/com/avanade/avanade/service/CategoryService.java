package com.avanade.avanade.service;

import java.util.List;
import java.util.Optional;

import com.avanade.avanade.entity.Category;
import com.avanade.avanade.repository.CategoriaFilterRepository;
import org.springframework.stereotype.Service;

import com.avanade.avanade.dto.CategoriaDTO;
import com.avanade.avanade.repository.CategoryRepository;


@Service
public class CategoryService {
    
    private CategoryRepository repository;
    private CategoriaFilterRepository filterRepository;

    public CategoryService(CategoryRepository repository, CategoriaFilterRepository filterRepository) {
        this.repository = repository;
        this.filterRepository = filterRepository;
    }

    public CategoriaDTO create(CategoriaDTO dto) {
        Category category = new Category(dto);
        category = this.repository.save(category);
        return category.dto();
    }


    public CategoriaDTO getOne(Long id) {
        Optional<Category> categoriaOp = this.repository.findById(id);
        return categoriaOp.get().dto();
    }


    public List<CategoriaDTO> getAll(CategoriaDTO dto) {
        return this.filterRepository.filter(dto).stream().map(categoria -> categoria.dto()).toList();
    }

    public CategoriaDTO edit(CategoriaDTO dto, Long id) {
        Category category = new Category(dto, id);
        category = this.repository.save(category);
        return category.dto();
    }

    public void delete(Long id) {
        this.repository.deleteById(id);

    }
}
