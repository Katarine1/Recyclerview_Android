package com.example.teste.model;

import java.io.Serializable;

public class Nomes implements Serializable {

    private int id;
    private String nome;

    public Nomes(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Nomes(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
