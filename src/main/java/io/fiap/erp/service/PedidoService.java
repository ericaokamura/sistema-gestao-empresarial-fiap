package io.fiap.erp.service;

import io.fiap.erp.mapper.ItemPedidoMapper;
import io.fiap.erp.mapper.PedidoMapper;
import io.fiap.erp.model.dto.PedidoDTO;
import io.fiap.erp.repository.PedidoRepository;
import io.fiap.erp.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoDTO salvarProduto(PedidoDTO pedidoDTO) {
        Pedido pedido = PedidoMapper.convertDTOToModel(pedidoDTO);
        pedido.setDataHoraPedido(LocalDateTime.now());
        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        return PedidoMapper.convertModelToDTO(pedidoSalvo);
    }

    public PedidoDTO atualizarPedido(Long idPedido, PedidoDTO pedidoDTO) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(idPedido);
        if(optionalPedido.isEmpty()) {
            throw new RuntimeException(); // criar exception customizada
        }
        Pedido pedido = optionalPedido.get();
        pedido.setItensPedido(ItemPedidoMapper.convertDTOListToModelList(pedidoDTO.getItensPedido()));
        pedido.setFormaPagamento(pedidoDTO.getFormaPagamento());
        pedido.setPagamentoAprovado(pedidoDTO.isPagamentoAprovado());
        pedido.setDataHoraPedido(LocalDateTime.now());
        Pedido pedidoAtualizado = pedidoRepository.save(pedido);
        return PedidoMapper.convertModelToDTO(pedidoAtualizado);
    }

    public PedidoDTO retornarPedido(Long idPedido) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(idPedido);
        if(optionalPedido.isEmpty()) {
            throw new RuntimeException(); // criar exception customizada
        }
        Pedido pedido = optionalPedido.get();
        return PedidoMapper.convertModelToDTO(pedido);
    }
    public List<PedidoDTO> retornarPedidos() {
        return PedidoMapper.converModelListToDTOList(pedidoRepository.findAll());
    }

    public void deletarTodosPedidos() {
        pedidoRepository.findAll().forEach(p -> pedidoRepository.delete(p));
    }
}
