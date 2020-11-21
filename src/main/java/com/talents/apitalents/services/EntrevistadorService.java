package com.talents.apitalents.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.talents.apitalents.dtos.entrevistador.EntrevistadorDTO;
import com.talents.apitalents.dtos.entrevistador.EntrevistadorInsertDTO;
import com.talents.apitalents.dtos.entrevistador.EntrevistadorUpdateDTO;
import com.talents.apitalents.dtos.entrevistador.esporte.EntrevistadorEsporteDTO;
import com.talents.apitalents.dtos.esporte.EsporteDTO;
import com.talents.apitalents.dtos.perfil.PerfilDTO;
import com.talents.apitalents.entities.Entrevistador;
import com.talents.apitalents.entities.Graduacao;
import com.talents.apitalents.repositories.EntrevistadorRepository;
import com.talents.apitalents.repositories.GraduacaoRepository;
import com.talents.apitalents.services.exceptions.CreateFileSearchesException;
import com.talents.apitalents.services.exceptions.EntityNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class EntrevistadorService {

    @Autowired
    private EntrevistadorRepository entrevistadorRepository;

    @Autowired
    private GraduacaoRepository graduacaoRepository;

    @Transactional(readOnly = true)
    public List<EntrevistadorDTO> findAll() {
        List<Entrevistador> entrevistadores = this.entrevistadorRepository.findAll();
        return entrevistadores.stream().map(entrevistador -> new EntrevistadorDTO(entrevistador))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EntrevistadorDTO findById(Integer id) {
        Entrevistador entrevistador = this.entrevistadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        EntrevistadorDTO entrevistadorDTO = new EntrevistadorDTO(entrevistador);
        return entrevistadorDTO;
    }

    @Transactional(readOnly = true)
    public EntrevistadorDTO findByEmail(String email) {
        Entrevistador entrevistador = this.entrevistadorRepository.findByEmail(email);
        if (entrevistador == null) {
            throw new EntityNotFoundException(email);
        }
        EntrevistadorDTO entrevistadorDTO = new EntrevistadorDTO(entrevistador);
        return entrevistadorDTO;
    }

    @Transactional(readOnly = false)
    public EntrevistadorDTO create(EntrevistadorInsertDTO entrevistadorInsertDTO) {
        Integer idGraduacao = entrevistadorInsertDTO.getIdGraduacao();
        String nome = entrevistadorInsertDTO.getNome();
        String email = entrevistadorInsertDTO.getEmail();
        String titulacao = entrevistadorInsertDTO.getTitulacao();
        Entrevistador entrevistador = new Entrevistador(nome, email, titulacao);
        Graduacao graduacao = this.graduacaoRepository.findById(idGraduacao)
                .orElseThrow(() -> new EntityNotFoundException(idGraduacao));
        entrevistador.setGraduacao(graduacao);
        entrevistador = this.entrevistadorRepository.save(entrevistador);
        EntrevistadorDTO entrevistadorDTO = new EntrevistadorDTO(entrevistador);
        return entrevistadorDTO;
    }

    @Transactional(readOnly = false)
    @Modifying
    public void update(EntrevistadorUpdateDTO entrevistadorUpdateDTO) {
        Integer id = entrevistadorUpdateDTO.getId();
        Integer idGraduacao = entrevistadorUpdateDTO.getIdGraduacao();
        String nome = entrevistadorUpdateDTO.getNome();
        String email = entrevistadorUpdateDTO.getEmail();
        String titulacao = entrevistadorUpdateDTO.getTitulacao();
        Entrevistador entrevistador = this.entrevistadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        Graduacao graduacao = this.graduacaoRepository.findById(idGraduacao)
                .orElseThrow(() -> new EntityNotFoundException(idGraduacao));
        entrevistador.setGraduacao(graduacao);
        entrevistador.setNome(nome);
        entrevistador.setEmail(email);
        entrevistador.setTitulacao(titulacao);
        this.entrevistadorRepository.save(entrevistador);
    }

    @Transactional(readOnly = false)
    public void delete(Integer idEntrevistador) {
        Entrevistador entrevistador = this.entrevistadorRepository.findById(idEntrevistador)
                .orElseThrow(() -> new EntityNotFoundException(idEntrevistador));
        this.entrevistadorRepository.delete(entrevistador);
    }

    @Transactional(readOnly = true)
    public HSSFWorkbook downloadPesquisas(Integer idEntrevistador) {
        EntrevistadorDTO entrevistadorDTO = this.findById(idEntrevistador);
        String arquivo = "pesquisas.xls";
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheetPesquisas = workbook.createSheet("Pesquisas");
        int rownum = 0;
        for (int i = 0; i < 1; i++) {
            Row row = sheetPesquisas.createRow(rownum++);
            int cellnum = 0;
            Cell cellEsporte = row.createCell(cellnum++);
            cellEsporte.setCellValue("Esporte");
            Cell cellAgilidade = row.createCell(cellnum++);
            cellAgilidade.setCellValue("Agilidade");
            Cell cellCoordenacaoMotora = row.createCell(cellnum++);
            cellCoordenacaoMotora.setCellValue("CoordenacaoMotora");
            Cell cellFlexibilidade = row.createCell(cellnum++);
            cellFlexibilidade.setCellValue("Flexibilidade");
            Cell cellForca = row.createCell(cellnum++);
            cellForca.setCellValue("Forca");
            Cell cellHipertrofia = row.createCell(cellnum++);
            cellHipertrofia.setCellValue("Hipertrofia");
            Cell cellPotencia = row.createCell(cellnum++);
            cellPotencia.setCellValue("Potencia");
            Cell cellResistencia = row.createCell(cellnum++);
            cellResistencia.setCellValue("Resistencia");
            Cell cellVelocidade = row.createCell(cellnum++);
            cellVelocidade.setCellValue("Velocidade");
            Cell cellEnvergaduraEstatura = row.createCell(cellnum++);
            cellEnvergaduraEstatura.setCellValue("EnvergaduraEstatura");
            Cell cellComprPernasEstatura = row.createCell(cellnum++);
            cellComprPernasEstatura.setCellValue("ComprPernasEstatura");
            Cell cellAlturaTroncoCefalicaEstatura = row.createCell(cellnum++);
            cellAlturaTroncoCefalicaEstatura.setCellValue("AlturaTroncoCefalicaEstatura");
            Cell cellImc = row.createCell(cellnum++);
            cellImc.setCellValue("Imc");
        }
        for (EntrevistadorEsporteDTO entrevistadorEsporteDTO : entrevistadorDTO.getEntrevistadorEsporteDTOs()) {
            PerfilDTO perfilDTO = entrevistadorEsporteDTO.getPerfilCustom();
            EsporteDTO esporteDTO = entrevistadorEsporteDTO.getEsporteDTO();
            int cellnum = 0;
            Row row = sheetPesquisas.createRow(rownum++);
            Cell cellNomeEsporte = row.createCell(cellnum++);
            cellNomeEsporte.setCellValue(esporteDTO.getNome());
            Cell cellAgilidade = row.createCell(cellnum++);
            cellAgilidade.setCellValue(perfilDTO.getAgilidade());
            Cell cellCoordenacaoMotora = row.createCell(cellnum++);
            cellCoordenacaoMotora.setCellValue(perfilDTO.getCoordenacaoMotora());
            Cell cellFlexibilidade = row.createCell(cellnum++);
            cellFlexibilidade.setCellValue(perfilDTO.getFlexibilidade());
            Cell cellForca = row.createCell(cellnum++);
            cellForca.setCellValue(perfilDTO.getForca());
            Cell cellHipertrofia = row.createCell(cellnum++);
            cellHipertrofia.setCellValue(perfilDTO.getHipertrofia());
            Cell cellPotencia = row.createCell(cellnum++);
            cellPotencia.setCellValue(perfilDTO.getPotencia());
            Cell cellResistencia = row.createCell(cellnum++);
            cellResistencia.setCellValue(perfilDTO.getResistencia());
            Cell cellVelocidade = row.createCell(cellnum++);
            cellVelocidade.setCellValue(perfilDTO.getVelocidade());
            Cell cellEnvergaduraEstatura = row.createCell(cellnum++);
            cellEnvergaduraEstatura.setCellValue(perfilDTO.getEnvergaduraEstatura());
            Cell cellComprPernasEstatura = row.createCell(cellnum++);
            cellComprPernasEstatura.setCellValue(perfilDTO.getComprPernasEstatura());
            Cell cellAlturaTroncoCefalicaEstatura = row.createCell(cellnum++);
            cellAlturaTroncoCefalicaEstatura.setCellValue(perfilDTO.getAlturaTroncoCefalicaEstatura());
            Cell cellIMC = row.createCell(cellnum++);
            cellIMC.setCellValue(perfilDTO.getImc());
        }
        try {
            File file = new File(arquivo);
            FileOutputStream out = new FileOutputStream(file);
            workbook.write(out);
            out.close();
            return workbook;
        } catch (IOException exception) {
            throw new CreateFileSearchesException("Can't create file with searches.");
        }
    }
}
