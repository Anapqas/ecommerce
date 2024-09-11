package com.avanade.avanade.entity;

import com.avanade.avanade.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Pessoas")
public class Pessoa {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String email;
  // @Column(name = "custom_name")
  private LocalDate birthdate;
  private String cpf;
  /*@ManyToMany(mappedBy = "pessoas")
  private List<Produto> produtos;*/

  public Pessoa(UserDTO dto) {
    this.birthdate = dto.birthdate();
    this.cpf = dto.cpf();
    this.email = dto.email();
    this.name = dto.name();
  }
}
