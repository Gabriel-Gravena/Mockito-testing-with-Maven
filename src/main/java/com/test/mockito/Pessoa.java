package com.test.mockito;

import java.time.LocalDate;

public class Pessoa {
    private String nome;

    private String documento;

    private LocalDate dataNascimento;

    private DadosLocalizacao endereco;

    public Pessoa(String nome, String documento, LocalDate dataNascimento) {
        this.nome = nome;
        this.documento = documento;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public void adicionarDadosDeEndereco(DadosLocalizacao dadosLocalizacao) {
        this.endereco = dadosLocalizacao;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public DadosLocalizacao getEndereco() {
        return endereco;
    }
}
