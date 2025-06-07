package br.com.landingpage.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoPersonalizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;      // Ex: "Animais e Bichinhos"
    private String nomeIcone;   // Ex: "heart"

    // Relacionamento: Muitos Tipos de Personalização pertencem a uma Categoria
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // Relacionamento: Um Tipo de Personalização tem uma lista de Itens (bullet points)
    @OneToMany(mappedBy = "tipoPersonalizacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPersonalizacao> itens = new ArrayList<>();

    // Construtor vazio para o JPA
    public TipoPersonalizacao() {
    }
    
    // Construtor para facilitar a criação
    public TipoPersonalizacao(String titulo, String nomeIcone, Categoria categoria) {
        this.titulo = titulo;
        this.nomeIcone = nomeIcone;
        this.categoria = categoria;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getNomeIcone() { return nomeIcone; }
    public void setNomeIcone(String nomeIcone) { this.nomeIcone = nomeIcone; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public List<ItemPersonalizacao> getItens() { return itens; }
    public void setItens(List<ItemPersonalizacao> itens) { this.itens = itens; }
}