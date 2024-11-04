package com.consultoria.triagem.model.output;

import lombok.*;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TriagemOutput {
	private UUID id;
	private UUID usuarioId;
	private int idade;
	private String profissao;
	private String perfilLinkedin;
	private String areaAtuacao;
	private int cargoAtual;
	private String areaDeInteresse;
	private int cargoDeInteresse;
	private int tempoParaAlcancarObjetivo;
	private Set<Integer> habilidades;
	private boolean ativo;
	private Instant updatedAt;
	private Instant createdAt;
}
