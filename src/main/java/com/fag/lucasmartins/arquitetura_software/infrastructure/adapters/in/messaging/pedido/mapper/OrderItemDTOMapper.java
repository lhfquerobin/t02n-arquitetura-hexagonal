package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.OrderItemEventoDTO;

public class OrderItemDTOMapper {

    public static PedidoProdutoBO toBo(OrderItemEventoDTO dto) {
        PedidoProdutoBO bo = new PedidoProdutoBO();
        bo.setQuantidade(dto.getAmount());
        var produto = new ProdutoBO();
        produto.setId(dto.getSku());
        bo.setProduto(produto);
        return bo;
    }
}
