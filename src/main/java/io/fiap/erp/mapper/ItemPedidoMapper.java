package io.fiap.erp.mapper;

import io.fiap.erp.model.ItemPedido;
import io.fiap.erp.model.dto.ItemPedidoDTO;

import java.util.ArrayList;
import java.util.List;

public class ItemPedidoMapper {
    public static List<ItemPedido> convertDTOListToModelList(List<ItemPedidoDTO> dtos) {
        List<ItemPedido> itens = new ArrayList<>();
        for (ItemPedidoDTO dto : dtos) {
            ItemPedido item = new ItemPedido();
            item.setIdProduto(dto.getIdProduto());
            item.setQuantidade(dto.getQuantidade());
            itens.add(item);
        }
        return itens;
    }
    public static List<ItemPedidoDTO> convertModelListToDTOList(List<ItemPedido> itens) {
        List<ItemPedidoDTO> dtos = new ArrayList<>();
        for (ItemPedido item : itens) {
            ItemPedidoDTO dto = new ItemPedidoDTO();
            dto.setIdProduto(item.getIdProduto());
            dto.setQuantidade(item.getQuantidade());
            dtos.add(dto);
        }
        return dtos;
    }
}
