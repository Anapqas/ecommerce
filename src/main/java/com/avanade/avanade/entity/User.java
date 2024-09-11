package com.avanade.avanade.entity;

import java.time.LocalDate;

import com.avanade.avanade.dto.UserDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String name;
    private String email;
    private LocalDate birthdate;
    private String cpf;

    public User(UserDTO dto){
        this.birthdate = dto.birthdate();
        this.cpf = dto.cpf();
        this.email = dto.email();
        this.name = dto.name();
        this.username = dto.username();
    }


    public User(UserDTO dto, Long id){
        this(dto);
        this.id = id;
    }

    public UserDTO dto() {
        return new UserDTO(this.name, this.cpf, this.email, this.username, this.birthdate, this.id);
    }



}
