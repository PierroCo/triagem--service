package com.consultoria.triagem.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTriagemInput {
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
