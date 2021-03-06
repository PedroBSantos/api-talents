package com.talents.apitalents.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.talents.apitalents.dtos.endereco.EnderecoInsertDTO;
import com.talents.apitalents.dtos.endereco.EnderecoUpdateDTO;
import com.talents.apitalents.dtos.entrevistado.EntrevistadoDTO;
import com.talents.apitalents.dtos.entrevistado.EntrevistadoInsertDTO;
import com.talents.apitalents.dtos.entrevistado.EntrevistadoUpdateDTO;
import com.talents.apitalents.entities.Endereco;
import com.talents.apitalents.entities.Entrevistado;
import com.talents.apitalents.repositories.EntrevistadoRepository;
import com.talents.apitalents.services.exceptions.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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

    @Transactional(readOnly = true)
    public EntrevistadoDTO findByEmail(String email) {
        Entrevistado entrevistado = this.entrevistadoRepository.findByEmail(email);
        if (entrevistado == null) {
            throw new EntityNotFoundException(email);
        }
        EntrevistadoDTO entrevistadoDTO = new EntrevistadoDTO(entrevistado);
        return entrevistadoDTO;
    }

    @Transactional(readOnly = true)
    public EntrevistadoDTO findById(Integer id) {
        Entrevistado entrevistado = this.entrevistadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        EntrevistadoDTO entrevistadoDTO = new EntrevistadoDTO(entrevistado);
        return entrevistadoDTO;
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

    @Transactional(readOnly = false)
    @Modifying
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
        this.entrevistadoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        this.enderecoService.update(enderecoUpdateDTO);
        Entrevistado entrevistado = this.entrevistadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        entrevistado.setNome(nome);
        entrevistado.setCpf(cpf);
        entrevistado.setRg(rg);
        entrevistado.setNomeMae(nomeMae);
        entrevistado.setEmail(email);
        entrevistado.setSexo(sexo);
        entrevistado.setEtnia(etnia);
        entrevistado.setTelefone(telefone);
        entrevistado.setDataNascimento(dataNascimento);
        this.entrevistadoRepository.save(entrevistado);
    }

    @Transactional(readOnly = false)
    public void delete(Integer idEntrevistado) {
        Entrevistado entrevistado = this.entrevistadoRepository.findById(idEntrevistado)
                .orElseThrow(() -> new EntityNotFoundException(idEntrevistado));
        this.entrevistadoRepository.delete(entrevistado);
    }
}
