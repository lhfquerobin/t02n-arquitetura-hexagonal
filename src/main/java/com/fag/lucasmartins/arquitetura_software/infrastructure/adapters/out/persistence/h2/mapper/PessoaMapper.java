package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;

public class PessoaMapper {

    public PessoaMapper() {
    }

    public static PessoaEntity toEntity(PessoaBO bo) {
        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setNome(bo.getNome());
        pessoaEntity.setEmail(bo.getEmail());
        pessoaEntity.setCpf(bo.getCpf());
        pessoaEntity.setTelefone(bo.getTelefone());
        pessoaEntity.setDataNascimento(bo.getDataNascimento());

        return pessoaEntity;
    }

    public static PessoaBO toBO(PessoaEntity entity) {
        PessoaBO bo = new PessoaBO();
        bo.setNome(entity.getNome());
        bo.setEmail(entity.getEmail());
        bo.setCpf(entity.getCpf());
        bo.setTelefone(entity.getTelefone());
        bo.setDataNascimento(entity.getDataNascimento());

        return bo;
    }
}
