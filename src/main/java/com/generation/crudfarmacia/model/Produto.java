package com.generation.crudfarmacia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O atributo nomeProduto é considerado obrigatório!")
    @Size(min = 5, max = 100, message = "O atributo nomeProduto deve conter no minimo 05 e no máximo 100 caracteres")
    private String nomeProduto;

    @NotNull(message = "O atributo descricaoProduto é obrigatório.")
    @Size(min = 10, max = 255, message = "O atributo descricaoProduto deve conter no minimo 10 e no máximo 255 caracteres")
    private String descricaoProduto;

    @NotNull(message = "O atributo estoque é considerado obrigatório!")
    private int estoqueProduto;

    @NotNull(message = "O atributo preco é considerado obrigatório!")
    private float precoProduto;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataValidadeProduto;

    @ManyToOne
    @JsonIgnoreProperties("produtos")
    private Categoria categoria;

    @ManyToOne
    @JsonIgnoreProperties("usuario")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public int getEstoqueProduto() {
        return estoqueProduto;
    }

    public void setEstoqueProduto(int estoqueProduto) {
        this.estoqueProduto = estoqueProduto;
    }

    public float getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(float precoProduto) {
        this.precoProduto = precoProduto;
    }

    public LocalDate getDataValidadeProduto() {
        return dataValidadeProduto;
    }

    public void setDataValidadeProduto(LocalDate dataValidadeProduto) {
        this.dataValidadeProduto = dataValidadeProduto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}