package com.talents.apitalents.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Entrevistado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 11, unique = true)
    private String cpf;
    @Column(nullable = false, length = 9, unique = false)
    private String rg;
    @Column(nullable = false, length = 50)
    private String nomeMae;
    @Column(nullable = true, length = 30, unique = true)
    private String email;
    @Column(length = 20)
    private String sexo;
    @Column(length = 20)
    private String etnia;
    @Column(length = 20)
    private String telefone;
    @Column(nullable = false)
    private LocalDate dataNascimento;
    @OneToOne
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;
    @OneToMany(mappedBy = "entrevistado")
    private List<Entrevista> entrevistas;

    public Entrevistado() {
        this.entrevistas = new ArrayList<>();
    }

    public Entrevistado(String nome, String cpf, String rg, String nomeMae, String email, String sexo, String etnia,
            String telefone, LocalDate dataNascimento, Endereco endereco) {
        this();
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.nomeMae = nomeMae;
        this.email = email;
        this.sexo = sexo;
        this.etnia = etnia;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Entrevista> getEntrevistas() {
        return entrevistas;
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
        Entrevistado other = (Entrevistado) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
