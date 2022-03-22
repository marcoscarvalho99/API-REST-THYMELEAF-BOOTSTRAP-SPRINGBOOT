package com.example.springmedico.Repository;

import com.example.springmedico.Modelo.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Override
    List<Medico> findAll();



}
