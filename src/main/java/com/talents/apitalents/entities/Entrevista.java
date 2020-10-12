package com.talents.apitalents.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Entrevista implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate dataEntrevista;
    @ManyToOne
    @JoinColumn(name = "idEntrevistado")
    private Entrevistado entrevistado;
    @ManyToOne
    @JoinColumn(name = "idEntrevistador")
    private Entrevistador entrevistador;
    @ManyToOne
    @JoinColumn(name = "idEsporte")
    private Esporte esporte;
    @OneToOne
    @JoinColumn(name = "idPerfilEntrevistado")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PerfilEntrevistado perfilEntrevistado;

    public Entrevista() {
    }

    public Entrevista(LocalDate dataEntrevista, Entrevistado entrevistado, Entrevistador entrevistador,
            Esporte esporte) {
        this.dataEntrevista = dataEntrevista;
        this.entrevistado = entrevistado;
        this.entrevistador = entrevistador;
        this.esporte = esporte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataEntrevista() {
        return dataEntrevista;
    }

    public void setDataEntrevista(LocalDate dataEntrevista) {
        this.dataEntrevista = dataEntrevista;
    }

    public Entrevistado getEntrevistado() {
        return entrevistado;
    }

    public void setEntrevistado(Entrevistado entrevistado) {
        this.entrevistado = entrevistado;
    }

    public Entrevistador getEntrevistador() {
        return entrevistador;
    }

    public void setEntrevistador(Entrevistador entrevistador) {
        this.entrevistador = entrevistador;
    }

    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }

    public PerfilEntrevistado getPerfilEntrevistado() {
        return perfilEntrevistado;
    }

    public void setPerfilEntrevistado(PerfilEntrevistado perfilEntrevistado) {
        this.perfilEntrevistado = perfilEntrevistado;
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
        Entrevista other = (Entrevista) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
