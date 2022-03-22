package com.example.springmedico.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cliente  {
//    extends RepresentationModel<Cliente>
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String nome;
    int idade;
    String cidade;
    String telefone;

    public Cliente get() {
        var  c = new Cliente();
        c.id=this.id;
        c.nome=this.nome;
        c.idade=this.idade;
        c.cidade=this.cidade;
        c.telefone=this.telefone;

        return c;
    }
}
