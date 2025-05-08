package io.fiap.erp.mapper;

import io.fiap.erp.model.ItemEstoque;
import io.fiap.erp.model.dto.ItemEstoqueDTO;

import java.util.ArrayList;
import java.util.List;

public class ItemEstoqueMapper {

    public static ItemEstoque convertDTOToModel(ItemEstoqueDTO dto) {
        ItemEstoque model = new ItemEstoque();
        model.setDescricao(dto.getDescricao());
        model.setQuantidade(dto.getQuantidade());
        //model.setDataHoraUltimaAtualizacao(dto.getDataHoraUltimaAtualizacao());
        return model;
    }

    public static ItemEstoqueDTO convertModelToDTO(ItemEstoque model) {
        ItemEstoqueDTO dto = new ItemEstoqueDTO();
        dto.setDescricao(model.getDescricao());
        dto.setQuantidade(model.getQuantidade());
        //dto.setDataHoraUltimaAtualizacao(model.getDataHoraUltimaAtualizacao());
        return dto;
    }

    public static List<ItemEstoque> convertDTOListToModelList(List<ItemEstoqueDTO> dtos) {
        List<ItemEstoque> itens = new ArrayList<>();
        for (ItemEstoqueDTO dto : dtos) {
            ItemEstoque model = new ItemEstoque();
            model.setDescricao(dto.getDescricao());
            model.setQuantidade(dto.getQuantidade());
            //model.setDataHoraUltimaAtualizacao(dto.getDataHoraUltimaAtualizacao());
            itens.add(model);
        }
        return itens;
    }

    public static List<ItemEstoqueDTO> convertModelListToDTOList(List<ItemEstoque> models) {
        List<ItemEstoqueDTO> dtos = new ArrayList<>();
        for (ItemEstoque model : models) {
            ItemEstoqueDTO dto = new ItemEstoqueDTO();
            dto.setDescricao(model.getDescricao());
            dto.setQuantidade(model.getQuantidade());
            //model.setDataHoraUltimaAtualizacao(dto.getDataHoraUltimaAtualizacao());
            dtos.add(dto);
        }
        return dtos;
    }
}
