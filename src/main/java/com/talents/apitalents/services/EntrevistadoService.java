package com.talents.apitalents.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.talents.apitalents.dtos.endereco.EnderecoInsertDTO;
import com.talents.apitalents.dtos.endereco.EnderecoUpdateDTO;
import com.talents.apitalents.dtos.entrevista.EntrevistaDTO;
import com.talents.apitalents.dtos.entrevistado.EntrevistadoDTO;
import com.talents.apitalents.dtos.entrevistado.EntrevistadoInsertDTO;
import com.talents.apitalents.dtos.entrevistado.EntrevistadoUpdateDTO;
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

    @Autowired
    private EntrevistaService entrevistaService;

    @Transactional(readOnly = true)
    public List<EntrevistadoDTO> findAll() {
        List<Entrevistado> entrevistados = this.entrevistadoRepository.findAll();
        return entrevistados.stream().map(entrevistado -> new EntrevistadoDTO(entrevistado))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = false)
    public EntrevistadoDTO create(EntrevistadoInsertDTO entrevistadoInsertDTO) {
        String nome = entrevistadoInsertDTO.getNome();
        String cpf = entrevistadoInsertDTO.getCpf();
        String rg = entrevistadoInsertDTO.getRg();
        String nomeMae = entrevistadoInsertDTO.getNomeMae();
        String email = entrevistadoInsertDTO.getEmail();
        String sexo = entrevistadoInsertDTO.getSexo();
        String etnia = entrevistadoInsertDTO.getEtnia();
        String telefone = entrevistadoInsertDTO.getTelefone();
        LocalDate dataNascimento = entrevistadoInsertDTO.getDataNascimento();
        EnderecoInsertDTO enderecoInsertDTO = entrevistadoInsertDTO.getEnderecoInsertDTO();
        Endereco endereco = this.enderecoService.create(enderecoInsertDTO);
        Entrevistado entrevistado = new Entrevistado(nome, cpf, rg, nomeMae, email, sexo, etnia, telefone,
                dataNascimento, endereco);
        entrevistado = this.entrevistadoRepository.save(entrevistado);
        EntrevistadoDTO entrevistadoDTO = new EntrevistadoDTO(entrevistado);
        return entrevistadoDTO;
    }

    public void update(EntrevistadoUpdateDTO entrevistadoUpdateDTO) {
        Integer id = entrevistadoUpdateDTO.getId();
        String nome = entrevistadoUpdateDTO.getNome();
        String cpf = entrevistadoUpdateDTO.getCpf();
        String rg = entrevistadoUpdateDTO.getRg();
        String nomeMae = entrevistadoUpdateDTO.getNomeMae();
        String email = entrevistadoUpdateDTO.getEmail();
        String sexo = entrevistadoUpdateDTO.getSexo();
        String etnia = entrevistadoUpdateDTO.getEtnia();
        String telefone = entrevistadoUpdateDTO.getTelefone();
        LocalDate dataNascimento = entrevistadoUpdateDTO.getDataNascimento();
        EnderecoUpdateDTO enderecoUpdateDTO = entrevistadoUpdateDTO.getEnderecoUpdateDTO();
        this.enderecoService.update(enderecoUpdateDTO);
        this.entrevistadoRepository.update(nome, cpf, rg, nomeMae, email, sexo, etnia, telefone, dataNascimento, id);
    }

    @Transactional(readOnly = false)
    public void delete(Integer idEntrevistado) {
        Entrevistado entrevistado = this.entrevistadoRepository.findById(idEntrevistado).get();
        List<EntrevistaDTO> entrevistaDTOs = this.entrevistaService.findByEntrevistado(idEntrevistado);
        for (EntrevistaDTO entrevistaDTO : entrevistaDTOs) {
            this.entrevistaService.delete(entrevistaDTO.getId());
        }
        this.entrevistadoRepository.delete(entrevistado);
    }
}
