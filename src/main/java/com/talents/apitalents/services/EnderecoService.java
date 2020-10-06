package com.talents.apitalents.services;

import com.talents.apitalents.dtos.endereco.EnderecoInsertDTO;
import com.talents.apitalents.dtos.endereco.EnderecoUpdateDTO;
import com.talents.apitalents.entities.Cidade;
import com.talents.apitalents.entities.Endereco;
import com.talents.apitalents.repositories.CidadeRepository;
import com.talents.apitalents.repositories.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional(readOnly = false)
    public Endereco create(EnderecoInsertDTO enderecoInsertDTO) {
        String rua = enderecoInsertDTO.getRua();
        String bairro = enderecoInsertDTO.getBairro();
        String complemento = enderecoInsertDTO.getComplemento();
        Integer idCidade = enderecoInsertDTO.getIdCidade();
        Cidade cidade = this.cidadeRepository.getOne(idCidade);
        Endereco endereco = new Endereco(rua, bairro, complemento, cidade);
        endereco = this.enderecoRepository.save(endereco);
        return endereco;
    }

    public void update(EnderecoUpdateDTO enderecoUpdateDTO) {
        Integer id = enderecoUpdateDTO.getId();
        Integer idCidade = enderecoUpdateDTO.getIdCidade();
        String rua = enderecoUpdateDTO.getRua();
        String bairro = enderecoUpdateDTO.getBairro();
        String complemento = enderecoUpdateDTO.getComplemento();
        this.enderecoRepository.update(rua, bairro, complemento, idCidade, id);
    }
}
