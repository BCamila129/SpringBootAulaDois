package com.example.demo.br.com.dto;

import org.springframework.web.bind.annotation.PutMapping;

public class ClienteDTO {

    private String endereco;

    public ClienteDTO(String nome, String endereco) {

        this.endereco = endereco;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
