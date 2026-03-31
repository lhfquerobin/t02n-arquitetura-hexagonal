package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;

public class PessoaDTOMapper {

    public PessoaDTOMapper() {
    }

    public static PessoaBO toBO(PessoaDTO dto) {
        PessoaBO bo = new PessoaBO();
        bo.setNome(dto.getNomeCompleto());
        bo.setTelefone(dto.getTelefone());
        bo.setEmail(dto.getEmail());
        bo.setCpf(dto.getCpf());
        bo.setDataNascimento(dto.getDataNascimento());
        return bo;
    }

    public static PessoaDTO toDTO(PessoaBO bo) {
        PessoaDTO dto = new PessoaDTO();
        dto.setNomeCompleto(bo.getNome());
        dto.setTelefone(bo.getTelefone());
        dto.setEmail(bo.getEmail());
        dto.setCpf(bo.getCpf());
        dto.setDataNascimento(bo.getDataNascimento());
        return dto;
    }
}
