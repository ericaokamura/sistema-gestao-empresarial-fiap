package io.fiap.erp.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FormaPagamentoDTO {

    private String descricao;
    private String codigo;
    private LocalDateTime dataHoraUltimaAtualizacao;
}
