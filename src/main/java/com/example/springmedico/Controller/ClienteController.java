package com.example.springmedico.Controller;

import com.example.springmedico.Modelo.Cliente;
import com.example.springmedico.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {


    ClienteService clienteService;

    @Autowired
    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @GetMapping
    public List<Cliente> buscarTodos(){

        return this.clienteService.buscarTodos();
    }
    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente c){

        return this.clienteService.cadastrarCliente(c);
    }
    @PutMapping(path = "{id}")
    public ResponseEntity <Cliente> atualizarCliente(@PathVariable Long id,@RequestBody Cliente c){

        try {
            clienteService.buscarUm(id);

        }catch (Exception e){
            System.out.println("erro");
            return ResponseEntity.notFound().build();
        }

        if(id.equals(c.getId())){
            clienteService.atualizarCliente(c);
            return ResponseEntity.ok(c);
        }else{
            System.out.println("ids diferentes");
            return ResponseEntity.notFound().build();

        }

    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id){

        try {

            this.clienteService.deletarCliente(id);

        }catch (Exception e){
            System.out.println("não existe");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();

    }
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Cliente> buscarUm(@PathVariable Long id){
        Optional<Cliente> clienteOptional;
       try {
           clienteOptional= Optional.of((clienteService.buscarUm(id).get()));
       }catch (Exception erro){
            System.out.println("erro");
           return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clienteOptional.get());

       //implementação do professor não funciona.
//        if(clienteOptional.isPresent()){
//            return ResponseEntity.ok(clienteOptional.get());
//        }else{
//            System.out.println("não presente");
//            return ResponseEntity.notFound().build();
//        }

    }


}
