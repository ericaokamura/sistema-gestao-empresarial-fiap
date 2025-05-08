package io.fiap.erp.model.dto;

import lombok.Data;
import io.fiap.erp.model.FormaPagamento;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoDTO {
    private String descricao;
    private List<ItemPedidoDTO> itensPedido;
    private FormaPagamento formaPagamento;
    private boolean pagamentoAprovado;
    private LocalDateTime dataHoraPedido;
}
