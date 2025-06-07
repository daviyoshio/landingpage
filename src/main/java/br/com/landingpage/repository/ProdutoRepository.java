package br.com.landingpage.repository;

import br.com.landingpage.model.Categoria;
import br.com.landingpage.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// Este repositório gerencia a entidade 'Produto', cujo ID é do tipo 'Long'.
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Da mesma forma, o Spring entende que este método deve buscar
    // uma LISTA de Produtos que pertencem a uma determinada 'Categoria'.
    List<Produto> findByCategoria(Categoria categoria);
}