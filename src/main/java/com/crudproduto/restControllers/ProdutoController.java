package com.crudproduto.restControllers;


import com.crudproduto.domain.Produto;
import com.crudproduto.dto.ProdutoDTO;
import com.crudproduto.services.ProdutoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Setter
@Getter
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public List<Produto> BuscarTudo() {
        produtoService.listarProdutos();
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> BuscarPorId(@PathVariable Long id) {
        produtoService.buscarProdutoPorId(id);
        return produtoService.buscarProdutoPorId(id);
    }

    @PostMapping
    public String Salvar(@RequestBody ProdutoDTO produtoDTO) {
        produtoDTO  = produtoService.salvarProduto(produtoDTO);
        return "Produto: " + produtoDTO.getNome() + " Salvo com sucesso!";
    }

    @PutMapping("/{id}")
    public String Atualizar(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
       produtoService.atualizarProduto(id, produtoDTO);
       return "Produto atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String Excluir(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return "Produto removido com sucesso!";
    }

}
