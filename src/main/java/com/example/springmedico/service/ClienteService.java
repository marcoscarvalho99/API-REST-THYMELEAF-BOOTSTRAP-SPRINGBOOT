package com.example.springmedico.service;

import com.example.springmedico.Modelo.Cliente;
import com.example.springmedico.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {



    ClienteRepository clienteRepository;
    @Autowired
    public void setClienteRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrarCliente(Cliente c){

        return this.clienteRepository.save(c);
    }

    public Cliente atualizarCliente(Cliente c){
       return clienteRepository.saveAndFlush(c);
    }

    public void deletarCliente(Long c){
        clienteRepository.deleteById(c);
    }

    public Cliente buscarUm(Long id){


        return clienteRepository.getById(id);

    }

    public List<Cliente> buscarTodos(){

       return clienteRepository.findAll();
    }



}
