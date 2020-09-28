package com.talents.apitalents.dtos;

import java.io.Serializable;

import com.talents.apitalents.entities.Endereco;

public class EnderecoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String rua;
    private String bairro;
    private String complemento;
    private CidadeDTO cidadeDTO;

    public EnderecoDTO() {
    }

    public EnderecoDTO(Endereco endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.bairro = endereco.getBairro();
        this.complemento = endereco.getComplemento();
        this.cidadeDTO = new CidadeDTO(endereco.getCidade());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public CidadeDTO getCidadeDTO() {
        return cidadeDTO;
    }

    public void setCidadeDTO(CidadeDTO cidadeDTO) {
        this.cidadeDTO = cidadeDTO;
    }
}
