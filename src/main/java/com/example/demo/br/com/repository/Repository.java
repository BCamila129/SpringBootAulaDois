package com.example.demo.br.com.repository;

import com.example.demo.br.com.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository  extends JpaRepository<Cliente, Long>{
}
