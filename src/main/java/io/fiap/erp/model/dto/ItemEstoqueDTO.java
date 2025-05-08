package io.fiap.erp.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ItemEstoqueDTO {

    private String descricao;
    private Long quantidade;
    private LocalDateTime dataHoraUltimaAtualizacao;
}
