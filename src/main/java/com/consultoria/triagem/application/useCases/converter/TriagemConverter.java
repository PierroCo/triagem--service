package com.consultoria.triagem.application.useCases.converter;

import com.consultoria.triagem.application.domain.Triagem;
import com.consultoria.triagem.model.input.PreencherTriagemInput;
import com.consultoria.triagem.model.output.TriagemOutput;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class TriagemConverter {

    public Triagem inputToObject(PreencherTriagemInput preencherTriagemInput) {
        return Triagem.builder()
                .usuarioId(preencherTriagemInput.getUsuarioId())
                .idade(preencherTriagemInput.getIdade())
                .profissao(preencherTriagemInput.getProfissao())
                .perfilLinkedin(preencherTriagemInput.getPerfilLinkedin())
                .areaAtuacao(preencherTriagemInput.getAreaAtuacao())
                .cargoAtual(preencherTriagemInput.getCargoAtual())
                .areaDeInteresse(preencherTriagemInput.getAreaDeInteresse())
                .cargoDeInteresse(preencherTriagemInput.getCargoDeInteresse())
                .tempoParaAlcancarObjetivo(preencherTriagemInput.getTempoParaAlcancarObjetivo())
                .build();
    }

    public TriagemOutput objectToOutput(Triagem triagem) {
        return TriagemOutput.builder()
                .id(triagem.getId())
                .usuarioId(triagem.getUsuarioId())
                .idade(triagem.getIdade())
                .profissao(triagem.getProfissao())
                .perfilLinkedin(triagem.getPerfilLinkedin())
                .areaAtuacao(triagem.getAreaAtuacao())
                .cargoAtual(triagem.getCargoAtual())
                .areaDeInteresse(triagem.getAreaDeInteresse())
                .cargoDeInteresse(triagem.getCargoDeInteresse())
                .tempoParaAlcancarObjetivo(triagem.getTempoParaAlcancarObjetivo())
                .ativo(triagem.isAtivo())
                .updatedAt(triagem.getUpdatedAt())
                .createdAt(triagem.getCreatedAt())
                .build();
    }
}
