package com.generation.crudfarmacia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O atributo nomeCategoria é obrigatório.")
    @Size(min = 5, max = 50, message = "O atributo nome deve conter no minimo 05 e no máximo 50 caracteres")
    private String nomeCategoria;

    @NotNull(message = "O Atributo Descrição é obrigatório")
    @Size(min = 10, max = 255, message = "Descrição precisa de no minímo 10 caracteres e no máximo 255")
    private String descricaoCategoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }
}
