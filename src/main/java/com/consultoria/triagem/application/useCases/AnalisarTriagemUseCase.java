package com.consultoria.triagem.application.useCases;

import com.consultoria.triagem.application.domain.Cargo;
import com.consultoria.triagem.application.domain.CargoHabilidade;
import com.consultoria.triagem.application.domain.Triagem;
import com.consultoria.triagem.application.domain.TriagemHabilidades;
import com.consultoria.triagem.application.useCases.exceptions.AnaliseTriagemException;
import com.consultoria.triagem.infrastructure.persistence.repository.CargoHabilidadeRepository;
import com.consultoria.triagem.infrastructure.persistence.repository.CargoRepository;
import com.consultoria.triagem.infrastructure.persistence.repository.TriagemHabilidadesRepository;
import com.consultoria.triagem.infrastructure.persistence.repository.TriagemRepository;
import com.consultoria.triagem.model.output.StatusAnaliseOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AnalisarTriagemUseCase {

    private final TriagemRepository triagemRepository;
    private final TriagemHabilidadesRepository triagemHabilidadesRepository;
    private final CargoRepository cargoRepository;
    private final CargoHabilidadeRepository cargoHabilidadeRepository;

    public StatusAnaliseOutput analisar(UUID triagemId) {
        Triagem triagem = buscarTriagem(triagemId);
        validarAreaECargoAtual(triagem);
        Cargo cargo = buscarCargo(triagem.getCargoDeInteresse());
        validarTempoParaObjetivo(triagem, cargo);
        validarHabilidades(triagemId, triagem.getCargoDeInteresse());

        return new StatusAnaliseOutput("Análise realizada com sucesso. Nenhuma inconsistência encontrada");
    }

    private Triagem buscarTriagem(UUID triagemId) {
        return triagemRepository.findById(triagemId)
                .orElseThrow(() -> new AnaliseTriagemException("ID da triagem não existe"));
    }

    private void validarAreaECargoAtual(Triagem triagem) {
        if (Objects.equals(triagem.getAreaAtuacao(), triagem.getAreaDeInteresse()) &&
                Objects.equals(triagem.getCargoAtual(), triagem.getCargoDeInteresse())) {
            throw new AnaliseTriagemException("O cargo/área de interesse deve ser diferente do cargo/área atual");
        }
    }

    private Cargo buscarCargo(Integer cargoDeInteresse) {
        return cargoRepository.findById(cargoDeInteresse)
                .orElseThrow(() -> new AnaliseTriagemException("Cargo de interesse não existe"));
    }

    private void validarTempoParaObjetivo(Triagem triagem, Cargo cargo) {
        if (triagem.getTempoParaAlcancarObjetivo() < cargo.getTempoMinimo()) {
            throw new AnaliseTriagemException(
                    "O cargo " + cargo.getDescricao() +
                            " não pode ser atingido num prazo inferior a " +
                            cargo.getTempoMinimo()
            );
        }
    }

    private void validarHabilidades(UUID triagemId, Integer cargoDeInteresse) {
        List<TriagemHabilidades> habilidadesTriagem = triagemHabilidadesRepository.findAllByTriagem_Id(triagemId);
        List<CargoHabilidade> habilidadesCargo = cargoHabilidadeRepository.findAllByCargoId(cargoDeInteresse);

        for (CargoHabilidade habilidadeCargo : habilidadesCargo) {
            if (habilidadesTriagem.stream().noneMatch(
                    habilidadeTriagem -> habilidadeTriagem.getHabilidade().equals(habilidadeCargo.getHabilidadeId())
            )) {
                throw new AnaliseTriagemException("O cliente não possui todas as habilidades para o cargo almejado");
            }
        }
    }
}
