package io.fiap.erp.mapper;

import io.fiap.erp.model.Produto;
import io.fiap.erp.model.dto.ProdutoDTO;

import java.util.ArrayList;
import java.util.List;

public class ProdutoMapper {

    public static Produto convertDTOToModel(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setDescricao(dto.getDescricao());
        produto.setValorUnitario(dto.getValorUnitario());
        return produto;
    }

    public static ProdutoDTO convertModelToDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setDescricao(produto.getDescricao());
        dto.setValorUnitario(produto.getValorUnitario());
        return dto;
    }

    public static List<Produto> converDTOListToModelList(List<ProdutoDTO> dtos) {
        List<Produto> produtos = new ArrayList<>();
        for (ProdutoDTO dto : dtos) {
            Produto produto = new Produto();
            produto.setDescricao(dto.getDescricao());
            produto.setValorUnitario(dto.getValorUnitario());
            produtos.add(produto);
        }
        return produtos;
    }

    public static List<ProdutoDTO> converModelListToDTOList(List<Produto> produtos) {
        List<ProdutoDTO> dtos = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoDTO dto = new ProdutoDTO();
            dto.setDescricao(produto.getDescricao());
            dto.setValorUnitario(produto.getValorUnitario());
            dtos.add(dto);
        }
        return dtos;
    }
}
