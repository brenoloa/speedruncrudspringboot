package com.crudproduto.repositories;

import com.crudproduto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{
}
