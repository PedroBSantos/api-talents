package com.talents.apitalents.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.talents.apitalents.dtos.EntrevistadorEsporteDTO;
import com.talents.apitalents.entities.Entrevistador;
import com.talents.apitalents.entities.EntrevistadorEsporte;
import com.talents.apitalents.entities.Esporte;
import com.talents.apitalents.entities.Graduacao;
import com.talents.apitalents.entities.PerfilEsportistaCustom;
import com.talents.apitalents.entities.PerfilEsportistaPadrao;
import com.talents.apitalents.repositories.EntrevistadorEsporteRepository;
import com.talents.apitalents.repositories.EntrevistadorRepository;
import com.talents.apitalents.repositories.EsporteRepository;
import com.talents.apitalents.repositories.GraduacaoRepository;
import com.talents.apitalents.repositories.PerfilEsportistaPadraoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntrevistadorEsporteService {

    @Autowired
    private EntrevistadorEsporteRepository entrevistadorEsporteRepository;

    @Autowired
    private PerfilEsportistaCustomService perfilEsportistaCustomService;

    @Autowired
    private EsporteRepository esporteRepository;

    @Autowired
    private PerfilEsportistaPadraoRepository perfilEsportistaPadraoRepository;

    @Autowired
    private EntrevistadorRepository entrevistadorRepository;

    @Autowired
    private GraduacaoRepository graduacaoRepository;

    @Transactional(readOnly = true)
    public List<EntrevistadorEsporteDTO> findByEntrevistador(Integer idEntrevistador) {
        Entrevistador entrevistador = new Entrevistador();
        entrevistador.setId(idEntrevistador);
        List<EntrevistadorEsporte> entrevistadorEsportes = this.entrevistadorEsporteRepository
                .findByEntrevistador(entrevistador);
        return entrevistadorEsportes.stream()
                .map(entrevistadorEsporte -> new EntrevistadorEsporteDTO(entrevistadorEsporte))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = false)
    public List<EntrevistadorEsporteDTO> create(List<EntrevistadorEsporteDTO> entrevistadorEsporteDTOs) {
        List<EntrevistadorEsporteDTO> entrevistadorEsporteDTOs2 = new ArrayList<>();
        for (EntrevistadorEsporteDTO entrevistadorEsporteDTO : entrevistadorEsporteDTOs) {
            Esporte esporte = this.esporteRepository.getOne(entrevistadorEsporteDTO.getEsporteDTO().getId());
            PerfilEsportistaPadrao perfilEsportistaPadrao = this.perfilEsportistaPadraoRepository
                    .getOne(entrevistadorEsporteDTO.getEsporteDTO().getId());
            esporte.setPerfilEsportistaPadrao(perfilEsportistaPadrao);
            Entrevistador entrevistador = this.entrevistadorRepository
                    .getOne(entrevistadorEsporteDTO.getEntrevistadorDTO().getId());
            Graduacao graduacao = this.graduacaoRepository
                    .getOne(entrevistadorEsporteDTO.getEntrevistadorDTO().getGraduacaoDTO().getId());
            entrevistador.setGraduacao(graduacao);
            PerfilEsportistaCustom perfilEsportistaCustom = this.perfilEsportistaCustomService
                    .create(entrevistadorEsporteDTO.getPerfilEsportistaCustomDTO());
            EntrevistadorEsporte entrevistadorEsporte = new EntrevistadorEsporte(entrevistador, esporte,
                    entrevistadorEsporteDTO.getAbrangencia(), entrevistadorEsporteDTO.getTempoExpertise(),
                    perfilEsportistaCustom);
            entrevistadorEsporte = this.entrevistadorEsporteRepository.save(entrevistadorEsporte);
            entrevistadorEsporteDTO = new EntrevistadorEsporteDTO(entrevistadorEsporte);
            entrevistadorEsporteDTOs2.add(entrevistadorEsporteDTO);
        }
        return entrevistadorEsporteDTOs2;
    }

    public EntrevistadorEsporteDTO update(EntrevistadorEsporteDTO entrevistadorEsporteDTO) {
        Integer idEntrevistadorEsporte = entrevistadorEsporteDTO.getId();
        String abrangencia = entrevistadorEsporteDTO.getAbrangencia();
        Integer tempoExpertise = entrevistadorEsporteDTO.getTempoExpertise();
        Integer idEsporte = entrevistadorEsporteDTO.getEsporteDTO().getId();
        Integer idPerfilEsportistaCustom = entrevistadorEsporteDTO.getPerfilEsportistaCustomDTO().getId();
        this.perfilEsportistaCustomService.update(entrevistadorEsporteDTO.getPerfilEsportistaCustomDTO());
        this.entrevistadorEsporteRepository.update(idEntrevistadorEsporte, abrangencia, tempoExpertise,
                idPerfilEsportistaCustom, idEsporte);
        EntrevistadorEsporte entrevistadorEsporte = this.entrevistadorEsporteRepository
                .findById(entrevistadorEsporteDTO.getId()).get();
        entrevistadorEsporteDTO = new EntrevistadorEsporteDTO(entrevistadorEsporte);
        return entrevistadorEsporteDTO;
    }

    @Transactional(readOnly = false)
    @Modifying
    public EntrevistadorEsporteDTO delete(Integer idEntrevistador, Integer idEntrevistadorEsporte) {
        EntrevistadorEsporte entrevistadorEsporte = this.entrevistadorEsporteRepository.findById(idEntrevistadorEsporte)
                .get();
        this.entrevistadorEsporteRepository.deleteById(idEntrevistadorEsporte);
        EntrevistadorEsporteDTO entrevistadorEsporteDTO = new EntrevistadorEsporteDTO(entrevistadorEsporte);
        return entrevistadorEsporteDTO;
    }
}
