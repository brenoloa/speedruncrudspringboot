package com.crudproduto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;

    private String nome;

    private String descricao;

    private Double preco;

    private int quantidade;

}
