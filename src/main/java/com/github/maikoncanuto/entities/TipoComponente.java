package com.github.maikoncanuto.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TB_TIPO_COMPONENTE")
@Cacheable
public class TipoComponente extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_TIPO_COMPONENTE", nullable = false, unique = true)
    private Long id;

    @Column(name = "DS_NOME", length = 100, nullable = false, unique = true)
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
