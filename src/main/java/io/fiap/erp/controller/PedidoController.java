package io.fiap.erp.controller;

import io.fiap.erp.model.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.fiap.erp.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDTO> salvarPedido(@RequestBody PedidoDTO pedidoDTO) {
        return ResponseEntity.ok(this.pedidoService.salvarProduto(pedidoDTO));
    }

    @PutMapping("/{idPedido}")
    public ResponseEntity<PedidoDTO> atualizarPedido(@PathVariable("idPedido") Long idPedido, @RequestBody PedidoDTO pedidoDTO) {
        return ResponseEntity.ok(this.pedidoService.atualizarPedido(idPedido, pedidoDTO));
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<PedidoDTO> retornarPedido(@PathVariable("idPedido") Long idPedido) {
        return ResponseEntity.ok(this.pedidoService.retornarPedido(idPedido));
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> retornarPedidos() {
        return ResponseEntity.ok(this.pedidoService.retornarPedidos());
    }

    @DeleteMapping
    public ResponseEntity deletarTodosPedidos() {
        this.pedidoService.deletarTodosPedidos();
        return ResponseEntity.ok().build();
    }
}
