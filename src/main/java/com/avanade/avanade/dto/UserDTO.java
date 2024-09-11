package com.avanade.avanade.dto;

import java.time.LocalDate;

public record UserDTO(String name, String cpf, String email, String username, LocalDate birthdate, Long id) {
      

}
