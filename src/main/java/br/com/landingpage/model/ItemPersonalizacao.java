package br.com.landingpage.model;

import jakarta.persistence.*;

@Entity
public class ItemPersonalizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto; // Ex: "Estojos em formato de animais fofos"

    // Relacionamento: Muitos Itens pertencem a um Tipo de Personalização
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_personalizacao_id")
    private TipoPersonalizacao tipoPersonalizacao;

    // Construtor vazio para o JPA
    public ItemPersonalizacao() {
    }

    // Construtor para facilitar a criação no DataLoader
    public ItemPersonalizacao(String texto, TipoPersonalizacao tipo) {
        this.texto = texto;
        this.tipoPersonalizacao = tipo;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }
    public TipoPersonalizacao getTipoPersonalizacao() { return tipoPersonalizacao; }
    public void setTipoPersonalizacao(TipoPersonalizacao tipoPersonalizacao) { this.tipoPersonalizacao = tipoPersonalizacao; }
}