package io.fiap.erp.controller;

import io.fiap.erp.model.dto.ItemEstoqueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.fiap.erp.service.ItemEstoqueService;

import java.util.List;

@RestController
@RequestMapping("itensEstoque")
public class ItemEstoqueController {

    @Autowired
    private ItemEstoqueService itemEstoqueService;

    @PostMapping
    public ResponseEntity<ItemEstoqueDTO> salvarItemEstoque(@RequestBody ItemEstoqueDTO itemEstoqueDTO) {
        return ResponseEntity.ok(this.itemEstoqueService.salvarItemEstoque(itemEstoqueDTO));
    }

    @PutMapping("/{idItemEstoque}")
    public ResponseEntity<ItemEstoqueDTO> atualizarItemEstoque(@PathVariable("idItemEstoque") Long idItemEstoque, @RequestBody ItemEstoqueDTO itemEstoqueDTO) {
        return ResponseEntity.ok(this.itemEstoqueService.atualizarItemEstoque(idItemEstoque, itemEstoqueDTO));
    }

    @GetMapping("/{idItemEstoque}")
    public ResponseEntity<ItemEstoqueDTO> retornarItemEstoque(@PathVariable("idItemEstoque") Long idItemEstoque) {
        return ResponseEntity.ok(this.itemEstoqueService.retornarItemEstoque(idItemEstoque));
    }

    @GetMapping
    public ResponseEntity<List<ItemEstoqueDTO>> retornarItensEstoque() {
        return ResponseEntity.ok(this.itemEstoqueService.retornarItensEstoque());
    }

}
