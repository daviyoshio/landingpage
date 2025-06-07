package br.com.landingpage.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // Avisa ao Spring que esta classe é uma tabela no banco de dados
public class Categoria {

    @Id // Marca este campo como a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o ID será gerado automaticamente
    private Long id;

    private String nomeSingular; // Ex: "Necessaire"
    private String nomePlural;   // Ex: "Necessaires"
    private String slug;         // Ex: "necessaires" (para usar na URL)

    @Column(length = 500) // Define um tamanho maior para a coluna de descrição
    private String descricao;

    private String imagemDestaqueUrl;
    private String urlImagemPersonalizacao; // <-- ADICIONE ESTA LINHA

    // Define o relacionamento: Uma Categoria pode ter muitos Produtos
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Produto> produtos = new ArrayList<>();

    // Getters e Setters (essenciais para o Spring funcionar)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeSingular() {
        return nomeSingular;
    }

    public void setNomeSingular(String nomeSingular) {
        this.nomeSingular = nomeSingular;
    }

    public String getNomePlural() {
        return nomePlural;
    }

    public void setNomePlural(String nomePlural) {
        this.nomePlural = nomePlural;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemDestaqueUrl() {
        return imagemDestaqueUrl;
    }

    public void setImagemDestaqueUrl(String imagemDestaqueUrl) {
        this.imagemDestaqueUrl = imagemDestaqueUrl;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    // ... outros getters e setters ...

    public String getUrlImagemPersonalizacao() {
        return urlImagemPersonalizacao;
    }

    public void setUrlImagemPersonalizacao(String urlImagemPersonalizacao) {
        this.urlImagemPersonalizacao = urlImagemPersonalizacao;
    }
}
