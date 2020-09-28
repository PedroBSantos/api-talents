package com.talents.apitalents.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.talents.apitalents.entities.Entrevistado;

public class EntrevistadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    private String nomeMae;
    private String email;
    private String sexo;
    private String etnia;
    private String telefone;
    private LocalDate dataNascimento;
    private EnderecoDTO enderecoDTO;

    public EntrevistadoDTO(Entrevistado entrevistado) {
        this.id = entrevistado.getId();
        this.nome = entrevistado.getNome();
        this.cpf = entrevistado.getCpf();
        this.rg = entrevistado.getRg();
        this.nomeMae = entrevistado.getNomeMae();
        this.email = entrevistado.getEmail();
        this.sexo = entrevistado.getSexo();
        this.etnia = entrevistado.getEtnia();
        this.telefone = entrevistado.getTelefone();
        this.dataNascimento = entrevistado.getDataNascimento();
        this.enderecoDTO = new EnderecoDTO(entrevistado.getEndereco());
    }

    public EntrevistadoDTO() {
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

    public EnderecoDTO getEnderecoDTO() {
        return enderecoDTO;
    }

    public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
        this.enderecoDTO = enderecoDTO;
    }
}
