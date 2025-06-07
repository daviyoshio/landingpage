// DepoimentoRepository.java
package br.com.landingpage.repository;
import br.com.landingpage.model.Categoria;
import br.com.landingpage.model.Depoimento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DepoimentoRepository extends JpaRepository<Depoimento, Long> {
    List<Depoimento> findByCategoria(Categoria categoria);
}