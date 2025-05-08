package io.fiap.erp.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProdutoDTO {
    private String descricao;
    private Double valorUnitario;
    private LocalDateTime dataHoraUltimaAtualizacao;
}
