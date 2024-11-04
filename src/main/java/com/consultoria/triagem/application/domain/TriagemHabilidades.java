package com.consultoria.triagem.application.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="triagem_habilidades")
public class TriagemHabilidades {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "triagem_id", nullable = false)
    private Triagem triagem;  // Alterado para ser uma relação com a entidade Triagem

    private Integer habilidade;
}
