package io.fiap.erp.service;

import io.fiap.erp.mapper.ItemEstoqueMapper;
import io.fiap.erp.model.dto.ItemEstoqueDTO;
import io.fiap.erp.model.ItemEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.fiap.erp.repository.ItemEstoqueRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ItemEstoqueService {

    @Autowired
    private ItemEstoqueRepository itemEstoqueRepository;

    public ItemEstoqueDTO salvarItemEstoque(ItemEstoqueDTO itemEstoqueDTO) {
        ItemEstoque itemEstoque = ItemEstoqueMapper.convertDTOToModel(itemEstoqueDTO);
        itemEstoque.setDataHoraUltimaAtualizacao(LocalDateTime.now());
        ItemEstoque itemEstoqueSalvo = itemEstoqueRepository.save(itemEstoque);
        return ItemEstoqueMapper.convertModelToDTO(itemEstoqueSalvo);
    }
    public ItemEstoqueDTO atualizarItemEstoque(Long idItemEstoque, ItemEstoqueDTO itemEstoqueDTO) {
        Optional<ItemEstoque> optionalItemEstoque = itemEstoqueRepository.findById(idItemEstoque);
        if(optionalItemEstoque.isEmpty()) {
            throw new RuntimeException(); // criar exception customizada
        }
        ItemEstoque itemEstoque = optionalItemEstoque.get();
        itemEstoque.setDescricao(itemEstoqueDTO.getDescricao());
        itemEstoque.setQuantidade(itemEstoqueDTO.getQuantidade());
        itemEstoque.setDataHoraUltimaAtualizacao(LocalDateTime.now());
        ItemEstoque itemEstoqueAtualizado = itemEstoqueRepository.save(itemEstoque);
        return ItemEstoqueMapper.convertModelToDTO(itemEstoqueAtualizado);
    }
    public ItemEstoqueDTO retornarItemEstoque(Long idItemEstoque) {
        Optional<ItemEstoque> optionalItemEstoque = itemEstoqueRepository.findById(idItemEstoque);
        if(optionalItemEstoque.isEmpty()) {
            throw new RuntimeException(); // criar exception customizada
        }
        ItemEstoque itemEstoque = optionalItemEstoque.get();
        return ItemEstoqueMapper.convertModelToDTO(itemEstoque);
    }
    public List<ItemEstoqueDTO> retornarItensEstoque() {
        return ItemEstoqueMapper.convertModelListToDTOList(itemEstoqueRepository.findAll());
    }
}
