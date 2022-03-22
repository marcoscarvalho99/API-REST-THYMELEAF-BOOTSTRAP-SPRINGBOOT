package com.example.springmedico.Repository;

import com.example.springmedico.Modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>  {


}
