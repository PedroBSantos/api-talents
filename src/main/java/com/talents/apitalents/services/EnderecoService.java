package com.talents.apitalents.services;

import com.talents.apitalents.dto.EnderecoDTO;
import com.talents.apitalents.entities.Cidade;
import com.talents.apitalents.entities.Endereco;
import com.talents.apitalents.entities.Estado;
import com.talents.apitalents.repository.CidadeRepository;
import com.talents.apitalents.repository.EnderecoRepository;
import com.talents.apitalents.repository.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional(readOnly = false)
    public Endereco create(EnderecoDTO enderecoDTO) {
        Integer idCidade = enderecoDTO.getCidadeDTO().getId();
        Integer idEstado = enderecoDTO.getCidadeDTO().getEstadoDTO().getId();
        String rua = enderecoDTO.getRua();
        String bairro = enderecoDTO.getBairro();
        String complemento = enderecoDTO.getComplemento();
        Estado estado = this.estadoRepository.getOne(idEstado);
        Cidade cidade = this.cidadeRepository.getOne(idCidade);
        cidade.setEstado(estado);
        Endereco endereco = new Endereco(rua, bairro, complemento, cidade);
        endereco = this.enderecoRepository.save(endereco);
        return endereco;
    }

    public void update(EnderecoDTO enderecoDTO) {
        String rua = enderecoDTO.getRua();
        String bairro = enderecoDTO.getBairro();
        String complemento = enderecoDTO.getComplemento();
        Integer idCidade = enderecoDTO.getCidadeDTO().getId();
        Integer idEndereco = enderecoDTO.getId();
        this.enderecoRepository.update(rua, bairro, complemento, idCidade, idEndereco);
    }
}
