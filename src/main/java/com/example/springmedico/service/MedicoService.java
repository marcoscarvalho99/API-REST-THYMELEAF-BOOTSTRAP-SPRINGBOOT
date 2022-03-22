package com.example.springmedico.service;

import com.example.springmedico.Modelo.Medico;
import com.example.springmedico.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class MedicoService {

    MedicoRepository medicoRepository;

    @Autowired
    public void setMedicoRepository(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> findAll(){ return medicoRepository.findAll(); }

    public void add(Medico m){
        medicoRepository.save(m);
    }

    public Medico buscarId(Long id){ return medicoRepository.getById(id); }

    public void deleteMedico(Long id){ medicoRepository.deleteById(id); }
    public void deletarPorNome(String name){


            var medicos = medicoRepository.findAll();

            medicos.forEach(medico -> {
                if(medico.getNome().toString().equals(name.toString()) ){
                    medicoRepository.deleteById(medico.getId());

                }


            });


    }
}
