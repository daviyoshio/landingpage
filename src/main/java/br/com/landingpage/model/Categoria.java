package br.com.landingpage.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeSingular;
    private String nomePlural;
    private String slug;

    @Column(length = 500)
    private String descricao;

    private String imagemDestaqueUrl;
    private String urlImagemPersonalizacao;

    private String ctaTitle;
    @Column(length = 500)
    private String ctaDescription;
    @Column(length = 500)
    private String ctaAttention;
    // NOVO ATRIBUTO PARA O TEXTO DO BOTÃO CTA
    private String ctaButtonText;
    
    // NOVOS ATRIBUTOS PARA A SEÇÃO HERO
    @Column(length = 500) // Título principal da Hero Section
    private String heroTitle;
    private String heroButtonText; // Texto do botão da Hero Section


    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Produto> produtos = new ArrayList<>();

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

    public String getUrlImagemPersonalizacao() {
        return urlImagemPersonalizacao;
    }

    public void setUrlImagemPersonalizacao(String urlImagemPersonalizacao) {
        this.urlImagemPersonalizacao = urlImagemPersonalizacao;
    }

    public String getCtaTitle() {
        return ctaTitle;
    }

    public void setCtaTitle(String ctaTitle) {
        this.ctaTitle = ctaTitle;
    }

    public String getCtaDescription() {
        return ctaDescription;
    }

    public void setCtaDescription(String ctaDescription) {
        this.ctaDescription = ctaDescription;
    }

    public String getCtaAttention() {
        return ctaAttention;
    }

    public void setCtaAttention(String ctaAttention) {
        this.ctaAttention = ctaAttention;
    }

    public String getCtaButtonText() {
        return ctaButtonText;
    }

    public void setCtaButtonText(String ctaButtonText) {
        this.ctaButtonText = ctaButtonText;
    }

    public String getHeroTitle() {
        return heroTitle;
    }

    public void setHeroTitle(String heroTitle) {
        this.heroTitle = heroTitle;
    }

    public String getHeroButtonText() {
        return heroButtonText;
    }

    public void setHeroButtonText(String heroButtonText) {
        this.heroButtonText = heroButtonText;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    
    
    
}