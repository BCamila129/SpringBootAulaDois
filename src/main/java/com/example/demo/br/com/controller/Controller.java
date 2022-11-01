package com.example.demo.br.com.controller;

import com.example.demo.br.com.repository.Repository;
import com.example.demo.br.com.dto.ClienteDTO;
import com.example.demo.br.com.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/cliente/v1/")
public class Controller {

    @Autowired
    Repository repository;

    @PostMapping
    public Cliente create(@RequestBody @Valid Cliente cliente) {
        Cliente clienteSaved = repository.save(cliente);
        return clienteSaved;
    }

    @ResponseBody
    public Optional<Cliente> getClienteById(@PathVariable Long id) {
        Optional<Cliente> clienteReturned = repository.findById(id);
        return clienteReturned;
    }
    @DeleteMapping("/{id}")
    public String deleteClienteById(@PathVariable Long id) {
        repository.deleteById(id);
        try {
            Optional<Cliente> cliente = Optional.of(repository.getById(id));
            if (cliente.isPresent()){
                repository.deleteById(id);
                return "Cliente de " + id + "deletado com sucesso";
            }else{
                throw new Exception("Cliente inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "O cliente de " + id + " não existe para ser deletado!" +
                    "Por favor, entre em contato com o atendimento 666 666 666";
        }
    }
    @GetMapping
    public List<Cliente> listClientes(){
        return repository.findAll();
    }

    @PutMapping("/atualize/{id}")
    public String updateClienteById(ClienteDTO clienteDTO, @PathVariable Long id){
        Optional<Cliente> velhoCliente = repository.findById(id);
        if(velhoCliente.isPresent()){
          Cliente cliente = velhoCliente.get();
          cliente.setEndereco(cliente.getEndereco());
          repository.save(cliente);
          return "Cliente de id " + cliente.getId() + " atualizado com sucesso!";
        }else{
            return "Cliente de id " + id + "não existe!";
        }

    }

}
