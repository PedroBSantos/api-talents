package com.talents.apitalents.dtos.endereco;

import java.io.Serializable;

public class EnderecoInsertDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String rua;
    private String bairro;
    private String complemento;
    private Integer idCidade;

    public EnderecoInsertDTO() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }
}
