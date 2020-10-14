package com.talents.apitalents.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class EntrevistadorEsporte implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idEntrevistador")
    private Entrevistador entrevistador;
    @ManyToOne
    @JoinColumn(name = "idEsporte")
    private Esporte esporte;
    @Column(nullable = false, length = 20)
    private String abrangencia;
    @Column(nullable = false)
    private Integer tempoExpertise;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idPerfilEsportistaCustom")
    private PerfilEsportistaCustom perfilEsportistaCustom;

    public EntrevistadorEsporte() {
    }

    public EntrevistadorEsporte(Entrevistador entrevistador, Esporte esporte, String abrangencia,
            Integer tempoExpertise, PerfilEsportistaCustom perfilEsportistaCustom) {
        this.entrevistador = entrevistador;
        this.esporte = esporte;
        this.abrangencia = abrangencia;
        this.tempoExpertise = tempoExpertise;
        this.perfilEsportistaCustom = perfilEsportistaCustom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAbrangencia() {
        return abrangencia;
    }

    public void setAbrangencia(String abrangencia) {
        this.abrangencia = abrangencia;
    }

    public Integer getTempoExpertise() {
        return tempoExpertise;
    }

    public void setTempoExpertise(Integer tempoExpertise) {
        this.tempoExpertise = tempoExpertise;
    }

    public PerfilEsportistaCustom getPerfilEsportistaCustom() {
        return perfilEsportistaCustom;
    }

    public void setPerfilEsportistaCustom(PerfilEsportistaCustom perfilEsportistaCustom) {
        this.perfilEsportistaCustom = perfilEsportistaCustom;
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
        EntrevistadorEsporte other = (EntrevistadorEsporte) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
