package com.example.springmedico.Modelo;

import com.example.springmedico.Mensagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @NotBlank
    @Size(min = 3, max = 7, message = Mensagem.erroTamMensagem)
    String nome;
   @NotBlank
   @NotNull
   @NotEmpty
    int idade;

}
