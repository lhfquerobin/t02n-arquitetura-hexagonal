package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class PessoaBO {

    private UUID id;

    private String nome;

    private String cpf;

    private LocalDate dataNascimento;

    private String email;

    private String telefone;

    public void validaMaioridade() {
        if (dataNascimento == null) {
            throw new DomainException("Data de nascimento deve ser informada");
        }

        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        int idade = periodo.getYears();

        if (idade < 18) {
            throw new DomainException("Idade deve ser maior ou igual a 18");
        }
    }

    public void validaCpf() {
        if (cpf == null || cpf.isEmpty()) {
            throw new DomainException("CPF deve ser informado");
        } else if (!cpf.matches("\\d{11}")) {
            throw new DomainException("CPF deve conter 11 dígitos numéricos");
        }
    }

    public void validaTelefone() {
        if (telefone == null || telefone.isEmpty()) {
            throw new DomainException("Telefone deve ser informado");
        } else if (!telefone.matches("\\d{11}")) {
            throw new DomainException("Telefone deve conter 11 dígitos numéricos");
        }
    }

    public void validaEmail() {
        if (email == null || email.isEmpty()) {
            throw new DomainException("Email deve ser informado");
        } else if (!email.contains("@")) {
            throw new DomainException("Email deve conter @");
        }
    }

    public void validarNome() {
        if (nome == null || nome.trim().isEmpty()) {
            throw new DomainException("Nome deve ser informado");
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
