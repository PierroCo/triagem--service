package com.consultoria.triagem.model.input;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreencherTriagemInput {
	private UUID usuarioId;
	private int idade;
	private String profissao;
	private String perfilLinkedin;
	private String areaAtuacao;
	private int cargoAtual;
	private String areaDeInteresse;
	private int cargoDeInteresse;
	private int tempoParaAlcancarObjetivo;
}
