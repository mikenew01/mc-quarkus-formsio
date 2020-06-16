package com.github.maikoncanuto.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_USUARIO", unique = true, nullable = false)
    private Long id;

    @Column(name = "DS_NOME", length = 100, nullable = false)
    private String nome;

    @Column(name = "DS_EMAIL", length = 100, unique = true, nullable = false)
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
