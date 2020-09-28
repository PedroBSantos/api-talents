package com.talents.apitalents.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.talents.apitalents.dtos.EnderecoDTO;
import com.talents.apitalents.dtos.EntrevistadoDTO;
import com.talents.apitalents.entities.Endereco;
import com.talents.apitalents.entities.Entrevistado;
import com.talents.apitalents.repositories.EntrevistadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntrevistadoService {

    @Autowired
    private EntrevistadoRepository entrevistadoRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Transactional(readOnly = true)
    public List<EntrevistadoDTO> findAll() {
        List<Entrevistado> entrevistados = this.entrevistadoRepository.findAll();
        return entrevistados.stream().map(entrevistado -> new EntrevistadoDTO(entrevistado))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = false)
    public EntrevistadoDTO create(EntrevistadoDTO entrevistadoDTO) {
        EnderecoDTO enderecoDTO = entrevistadoDTO.getEnderecoDTO();
        String nome = entrevistadoDTO.getNome();
        String cpf = entrevistadoDTO.getCpf();
        String rg = entrevistadoDTO.getRg();
        String nomeMae = entrevistadoDTO.getNomeMae();
        String email = entrevistadoDTO.getEmail();
        String sexo = entrevistadoDTO.getSexo();
        String etnia = entrevistadoDTO.getEtnia();
        String telefone = entrevistadoDTO.getTelefone();
        LocalDate dataNascimento = entrevistadoDTO.getDataNascimento();
        Endereco endereco = this.enderecoService.create(enderecoDTO);
        Entrevistado entrevistado = new Entrevistado(nome, cpf, rg, nomeMae, email, sexo, etnia, telefone,
                dataNascimento, endereco);
        entrevistado = this.entrevistadoRepository.save(entrevistado);
        entrevistadoDTO = new EntrevistadoDTO(entrevistado);
        return entrevistadoDTO;
    }

    // @Transactional(readOnly = false)
    // public void delete(EntrevistadoDTO entrevistadoDTO) {
    //     Integer idEntrevistado = entrevistadoDTO.getId();
    //     EnderecoDTO enderecoDTO = entrevistadoDTO.getEnderecoDTO();
    //     this.entrevistadoRepository.deleteById(idEntrevistado);
    //     this.enderecoService.delete(enderecoDTO);
    // }

    public EntrevistadoDTO update(EntrevistadoDTO entrevistadoDTO) {
        Integer idEntrevistado = entrevistadoDTO.getId();
        String nome = entrevistadoDTO.getNome();
        String cpf = entrevistadoDTO.getCpf();
        String rg = entrevistadoDTO.getRg();
        String nomeMae = entrevistadoDTO.getNomeMae();
        String email = entrevistadoDTO.getEmail();
        String sexo = entrevistadoDTO.getSexo();
        String etnia = entrevistadoDTO.getEtnia();
        String telefone = entrevistadoDTO.getTelefone();
        LocalDate dataNascimento = entrevistadoDTO.getDataNascimento();
        EnderecoDTO enderecoDTO = entrevistadoDTO.getEnderecoDTO();
        this.enderecoService.update(enderecoDTO);
        this.entrevistadoRepository.update(nome, cpf, rg, nomeMae, email, sexo, etnia, telefone, dataNascimento,
                idEntrevistado);
        Entrevistado entrevistado = this.entrevistadoRepository.findById(entrevistadoDTO.getId()).get();
        entrevistadoDTO = new EntrevistadoDTO(entrevistado);
        return entrevistadoDTO;
    }
}
