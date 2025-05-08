package io.fiap.erp.controller;

import io.fiap.erp.model.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.fiap.erp.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvarItemEstoque(@RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(this.produtoService.salvarProduto(produtoDTO));
    }

    @PutMapping("/{idProduto}")
    public ResponseEntity<ProdutoDTO> atualizarItemEstoque(@PathVariable("idProduto") Long idProduto, @RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(this.produtoService.atualizarProduto(idProduto, produtoDTO));
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<ProdutoDTO> retornarItemEstoque(@PathVariable("idProduto") Long idProduto) {
        return ResponseEntity.ok(this.produtoService.retornarProduto(idProduto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> retornarItensEstoque() {
        return ResponseEntity.ok(this.produtoService.retornarProdutos());
    }

}
