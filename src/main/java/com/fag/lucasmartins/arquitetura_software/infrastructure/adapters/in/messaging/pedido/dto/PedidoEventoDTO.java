package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoEventoDTO {
    private String zipCode;
    private Integer customerId;
    private List<OrderItemEventoDTO> orderItems;
    private String origin;
    private LocalDateTime occurredAt;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<OrderItemEventoDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEventoDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(LocalDateTime occurredAt) {
        this.occurredAt = occurredAt;
    }
}
