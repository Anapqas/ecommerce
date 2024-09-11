package com.avanade.avanade.entity;

import com.avanade.avanade.dto.ProductDTO;

import jakarta.persistence.*;
import lombok.Data;
/* import lombok.Getter;
import lombok.Setter; */
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Integer estoque;
    private Double preco;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
   /* @ManyToMany
    @JoinTable(name = "vendas",
        joinColumns = @JoinColumn(name = "id_produto"),
        inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
    private List<Pessoa> pessoas;*/

    public Product(ProductDTO dto, Category category){
        this.nome = dto.nome();
        this.estoque = dto.estoque();
        this.preco = dto.preco();
        this.category = category;
    }

    public Product(ProductDTO dto,Category category, Long id){
        this(dto, category);
        this.id = id;
    }

    public ProductDTO toDto(){
        return new ProductDTO(this.id,this.nome,this.estoque,this.preco, this.category.getId());
    }
}
