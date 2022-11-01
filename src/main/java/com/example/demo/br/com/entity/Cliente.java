package com.example.demo.br.com.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String endereco;
    @OneToMany(cascade = CascadeType.ALL) //Relacionamento entre tabela de cliente e produto
    private List<Produto> produtos;


    public List<Produto> getProdutos() {
        return produtos;
    }

    public Cliente(String nome, String endereco, List<Produto> produtos) {
        this.nome = nome;
        this.endereco = endereco;
        this.produtos = produtos;
    }

    public Cliente(){

    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}
