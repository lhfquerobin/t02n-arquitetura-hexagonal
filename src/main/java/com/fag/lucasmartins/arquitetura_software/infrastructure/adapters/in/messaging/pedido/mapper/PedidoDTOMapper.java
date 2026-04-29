package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper;

import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.PedidoEventoDTO;

public class PedidoDTOMapper {

    public static PedidoBO toBO(PedidoEventoDTO dto) {
        PedidoBO bo = new PedidoBO();
        var pessoa = new PessoaBO();
        pessoa.setId(dto.getCustomerId());
        bo.setPessoa(pessoa);
        bo.setCep(dto.getZipCode());
        bo.setItens(
                dto.getOrderItems().stream()
                        .map(OrderItemDTOMapper::toBo)
                        .toList()
        );
        bo.setValorTotal(
                bo.getItens().stream()
                        .mapToDouble(item ->
                                item.getQuantidade() * item.getProduto().getPrecoFinal()
                        )
                        .sum()
        );
        return bo;
    }
}
