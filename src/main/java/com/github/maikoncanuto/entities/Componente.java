package com.github.maikoncanuto.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TB_COMPONENTE")
public class Componente extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_COMPONENTE", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_COMPONENTE", referencedColumnName = "ID_TIPO_COMPONENTE", nullable = false)
    private TipoComponente tipoComponente;

    @ManyToOne
    @JoinColumn(name = "ID_FORMULARIO", referencedColumnName = "ID_FORMULARIO", nullable = false)
    private Formulario formulario;

    @Column(name = "DS_PERGUNTA", length = 100, nullable = false)
    private String pergunta;

    @Column(name = "DS_DESCRICAO", length = 100)
    private String descricao;

    @Column(name = "DS_ORDEM")
    private Integer ordem = 0;

    @Column(name = "DS_DICA", length = 100)
    private String dica;

    @Column(name = "DS_OPCOES", length = 500)
    private String opcoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoComponente getTipoComponente() {
        return tipoComponente;
    }

    public void setTipoComponente(TipoComponente tipoComponente) {
        this.tipoComponente = tipoComponente;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    public String getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(String opcoes) {
        this.opcoes = opcoes;
    }
}
