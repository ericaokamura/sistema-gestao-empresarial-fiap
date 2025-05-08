package io.fiap.erp.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<ItemPedido> itensPedido;
    @OneToOne
    private FormaPagamento formaPagamento;
    private boolean pagamentoAprovado;
    private LocalDateTime dataHoraPedido;
}

