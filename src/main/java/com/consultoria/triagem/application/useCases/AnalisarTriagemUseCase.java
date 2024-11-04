package com.consultoria.triagem.application.useCases;

import com.consultoria.triagem.application.domain.Cargo;
import com.consultoria.triagem.application.domain.CargoHabilidade;
import com.consultoria.triagem.application.domain.Triagem;
import com.consultoria.triagem.application.domain.TriagemHabilidades;
import com.consultoria.triagem.application.useCases.exceptions.AnaliseTriagemException;
import com.consultoria.triagem.infrastructure.persistence.repository.CargoHabilidadeRepository;
import com.consultoria.triagem.model.output.StatusAnaliseOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AnalisarTriagemUseCase {

    private final CargoHabilidadeRepository cargoHabilidadeRepository;

    public StatusAnaliseOutput analisar(UUID triagemId) {

        List<CargoHabilidade> habilidadesCargo = cargoHabilidadeRepository.findAllByCargoIdIs(triagem.getCargoDeInteresse());
        Cargo cargo = cargoRepository.findById(triagem.getCargoDeInteresse()).orElseThrow(() -> new AnaliseTriagemException("Cargo de interesse não existe"));

        if (triagem.getAreaAtuacao() == triagem.getAreaDeInteresse() &&
                triagem.getCargoAtual() == triagem.getCargoDeInteresse()) {
            throw new AnaliseTriagemException("O cargo/área de interesse deve ser diferente do cargo/área atual");
        }

        if (triagem.getTempoParaAlcancarObjetivo() > cargo.getTempoMinimo()) {
            throw new AnaliseTriagemException(
                    "O cargo " + cargo.getDescricao() +
                            " não pode ser atingido num prazo inferior a " +
                            cargo.getTempoMinimo()
            );
        }

        boolean encontrou;

        for (CargoHabilidade habilidadeCargo : habilidadesCargo) {
            encontrou = false;

            for (TriagemHabilidades habilidadeTriagem : habilidadesTriagem) {
                if (habilidadeTriagem.getHabilidade().equals(habilidadeCargo.getHabilidadeId())) {
                    encontrou = true;
                    break;
                }
            }

            if (!encontrou) {
                throw new AnaliseTriagemException("O cliente não possui todas as habilidades para o cargo almejado");
            }
        }

        return new StatusAnaliseOutput(
                "Análise realizada com sucesso. Nenhuma inconsistência encontrada"
        );
    }
}
