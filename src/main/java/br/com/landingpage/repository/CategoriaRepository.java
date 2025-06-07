package br.com.landingpage.repository;

import br.com.landingpage.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// JpaRepository nos dá vários métodos prontos, como save(), findAll(), findById(), etc.
// Indicamos que ele vai gerenciar a entidade 'Categoria', cujo ID é do tipo 'Long'.
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Nós só precisamos criar este método.
    // O Spring entende pelo nome "findBySlug" que ele deve criar uma
    // consulta para buscar uma Categoria pela sua coluna "slug".
    // Optional significa que ele pode ou não encontrar uma categoria.
    Optional<Categoria> findBySlug(String slug);
}