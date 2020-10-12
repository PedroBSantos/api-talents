package com.talents.apitalents.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Entrevistador implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = true, length = 75, unique = true)
    private String email;
    @Column(nullable = false, length = 50)
    private String titulacao;
    @ManyToOne
    @JoinColumn(name = "idGraduacao")
    private Graduacao graduacao;
    @OneToMany(mappedBy = "entrevistador")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Entrevista> entrevistas;
    @OneToMany(mappedBy = "entrevistador")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<EntrevistadorEsporte> entrevistadorEsportes;

    public Entrevistador() {
        this.entrevistas = new ArrayList<>();
        this.entrevistadorEsportes = new ArrayList<>();
    }

    public Entrevistador(String nome, String email, String titulacao) {
        this();
        this.nome = nome;
        this.email = email;
        this.titulacao = titulacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public Graduacao getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(Graduacao graduacao) {
        this.graduacao = graduacao;
    }

    public List<Entrevista> getEntrevistas() {
        return entrevistas;
    }

    public List<EntrevistadorEsporte> getEntrevistadorEsportes() {
        return entrevistadorEsportes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Entrevistador other = (Entrevistador) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
