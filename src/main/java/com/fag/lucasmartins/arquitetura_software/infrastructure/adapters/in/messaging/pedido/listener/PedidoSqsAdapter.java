package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.listener;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.exceptions.ConsumerSQSException;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.PedidoEventoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper.PedidoDTOMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PedidoSqsAdapter {

    private static final Logger log = LoggerFactory.getLogger(PedidoSqsAdapter.class);

    private final PedidoServicePort pedidoService;
    public PedidoSqsAdapter(PedidoServicePort pedidoService) {
        this.pedidoService = pedidoService;
    }

    @SqsListener(value = "${queue.order-events}")
    public void receberMensagem(PedidoEventoDTO evento) {
        try {
            log.info("Evento de pedido recebido para o cliente de ID {}", evento.getCustomerId());

            final PedidoBO bo = PedidoDTOMapper.toBO(evento);
            pedidoService.criarPedido(bo);

            log.info("Pedido processado para o cliente de ID {}", evento.getCustomerId());
        } catch (Exception e) {
            log.error("Erro ao processar o evento de pedido para o cliente {}", evento.getCustomerId(), e);
            throw new ConsumerSQSException("erro ao processar o evento de pedido para o cliente " + evento.getCustomerId(), e);
        }
    }
}
