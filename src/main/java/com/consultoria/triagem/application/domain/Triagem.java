package com.consultoria.triagem.application.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Entity
@Table(name="triagem")
public class Triagem {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;
    @NotNull(message = "User ID is required")
    @Column(nullable = false)
    private UUID usuarioId;
    @Column(nullable = false)
    private int idade;
    @NotBlank(message = "Profession is required")
    @Size(max = 100, message = "Profession must be up to 100 characters")
    @Column(nullable = false, length = 100)
    private String profissao;
    @Size(max = 200, message = "LinkedIn profile link must be up to 200 characters")
    private String perfilLinkedin;
    @Size(max = 50, message = "Activity area must be up to 50 characters")
    private String areaAtuacao;
    @Size(max = 100, message = "Current position must be up to 100 characters")
    private int cargoAtual;
    @Size(max = 100, message = "Area of interest must be up to 100 characters")
    private String areaDeInteresse;
    @Size(max = 100, message = "Desired position must be up to 100 characters")
    private int cargoDeInteresse;
    @Positive(message = "Time to achieve goal must be a valid date.")
    private int tempoParaAlcancarObjetivo;
    @Column(nullable = false)
    private Set<Integer> habilidades;

    @Builder.Default
    private boolean ativo = true;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Instant updatedAt;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Instant createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
}


