package com.crudproduto.services;


import com.crudproduto.domain.Produto;
import com.crudproduto.dto.ProdutoDTO;
import com.crudproduto.repositories.ProdutoRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidade(produtoDTO.getQuantidade());
        produto.setNome(produtoDTO.getNome());
        produtoRepository.save(produto);
        return new ProdutoDTO(produtoDTO.getId(),
                produtoDTO.getNome(),
                produtoDTO.getDescricao(),
                produtoDTO.getPreco(),
                produtoDTO.getQuantidade());
    }

    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public void atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.findById(id).get();
        if (produtoDTO.getDescricao() != null) {
            produto.setDescricao(produtoDTO.getDescricao());
        }
        if (produtoDTO.getPreco() != null) {
            produto.setPreco(produtoDTO.getPreco());
        }
        if (produtoDTO.getQuantidade() != produto.getQuantidade()){
            produto.setQuantidade(produtoDTO.getQuantidade());
        }
        if (produtoDTO.getNome() != null) {
            produto.setNome(produtoDTO.getNome());
        }
        produtoRepository.save(produto);

    }
}
