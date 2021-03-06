package com.talents.apitalents.services;

import com.talents.apitalents.dtos.endereco.EnderecoInsertDTO;
import com.talents.apitalents.dtos.endereco.EnderecoUpdateDTO;
import com.talents.apitalents.entities.Endereco;
import com.talents.apitalents.repositories.EnderecoRepository;
import com.talents.apitalents.services.exceptions.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional(readOnly = false)
    public Endereco create(EnderecoInsertDTO enderecoInsertDTO) {
        String cep = enderecoInsertDTO.getCep();
        String logradouro = enderecoInsertDTO.getLogradouro();
        String complemento = enderecoInsertDTO.getComplemento();
        String bairro = enderecoInsertDTO.getBairro();
        String localidade = enderecoInsertDTO.getLocalidade();
        String uf = enderecoInsertDTO.getUf();
        Endereco endereco = new Endereco(cep, logradouro, complemento, bairro, localidade, uf);
        endereco = this.enderecoRepository.save(endereco);
        return endereco;
    }

    @Transactional(readOnly = false)
    @Modifying
    public void update(EnderecoUpdateDTO enderecoUpdateDTO) {
        Integer idEndereco = enderecoUpdateDTO.getId();
        String cep = enderecoUpdateDTO.getCep();
        String logradouro = enderecoUpdateDTO.getLogradouro();
        String complemento = enderecoUpdateDTO.getComplemento();
        String bairro = enderecoUpdateDTO.getBairro();
        String localidade = enderecoUpdateDTO.getLocalidade();
        String uf = enderecoUpdateDTO.getUf();
        Endereco endereco = this.enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new EntityNotFoundException(idEndereco));
        endereco.setCep(cep);
        endereco.setLocalidade(localidade);
        endereco.setComplemento(complemento);
        endereco.setBairro(bairro);
        endereco.setLogradouro(logradouro);
        endereco.setUf(uf);
        this.enderecoRepository.save(endereco);
    }
}
