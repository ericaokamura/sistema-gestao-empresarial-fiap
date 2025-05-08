package io.fiap.erp.mapper;

import io.fiap.erp.model.Pedido;
import io.fiap.erp.model.dto.PedidoDTO;

import java.util.ArrayList;
import java.util.List;

public class PedidoMapper {

    public static Pedido convertDTOToModel(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setItensPedido(ItemPedidoMapper.convertDTOListToModelList(dto.getItensPedido()));
        pedido.setFormaPagamento(dto.getFormaPagamento());
        pedido.setPagamentoAprovado(dto.isPagamentoAprovado());
        return pedido;
    }

    public static PedidoDTO convertModelToDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setItensPedido(ItemPedidoMapper.convertModelListToDTOList(pedido.getItensPedido()));
        dto.setFormaPagamento(pedido.getFormaPagamento());
        dto.setPagamentoAprovado(pedido.isPagamentoAprovado());
        return dto;
    }

    public static List<Pedido> converDTOListToModelList(List<PedidoDTO> dtos) {
        List<Pedido> pedidos = new ArrayList<>();
        for (PedidoDTO dto : dtos) {
            Pedido pedido = new Pedido();
            pedido.setItensPedido(ItemPedidoMapper.convertDTOListToModelList(dto.getItensPedido()));
            pedido.setFormaPagamento(dto.getFormaPagamento());
            pedido.setPagamentoAprovado(dto.isPagamentoAprovado());
            pedidos.add(pedido);
        }
        return pedidos;
    }

    public static List<PedidoDTO> converModelListToDTOList(List<Pedido> pedidos) {
        List<PedidoDTO> dtos = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            PedidoDTO dto = new PedidoDTO();
            dto.setItensPedido(ItemPedidoMapper.convertModelListToDTOList(pedido.getItensPedido()));
            dto.setFormaPagamento(pedido.getFormaPagamento());
            dto.setPagamentoAprovado(pedido.isPagamentoAprovado());
            dtos.add(dto);
        }
        return dtos;
    }
}
