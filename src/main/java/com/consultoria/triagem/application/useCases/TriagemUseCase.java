package com.consultoria.triagem.application.useCases;

import com.consultoria.triagem.application.domain.exceptions.ScreeningNotFoundException;
import com.consultoria.triagem.application.domain.Triagem;
import com.consultoria.triagem.application.useCases.converter.TriagemConverter;
import com.consultoria.triagem.infrastructure.persistence.repository.CargoHabilidadeRepository;
import com.consultoria.triagem.model.input.PreencherTriagemInput;
import com.consultoria.triagem.model.input.UpdateTriagemInput;
import com.consultoria.triagem.model.output.TriagemOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TriagemUseCase {

    private final TriagemConverter triagemConverter;
    private final TriagemRepository triagemRepository;
    private final TriagemHabilidadesRepository triagemHabilidadesRepository;
    private final CargoRepository cargoRepository;
    private final CargoHabilidadeRepository cargoHabilidadeRepository;

    public TriagemOutput criarTriagem(PreencherTriagemInput preencherTriagemInput) {
        Triagem triagem = triagemConverter.inputToObject(preencherTriagemInput);
        Triagem savedEntity = triagemRepository.save(triagem);
        return triagemConverter.objectToOutput(savedEntity);
    }

    public TriagemOutput getTriagemById(UUID id) {
        Triagem triagem = triagemRepository.findById(id)
                .orElseThrow(() -> new ScreeningNotFoundException("Screening not found with ID: " + id));
        return triagemConverter.objectToOutput(triagem);
    }

    public List<TriagemOutput> getTriagemByUserId(UUID userId) {
        Optional<Triagem> triagens = triagemRepository.findByUserId(userId);

        if (triagens.isEmpty()) {
            throw new ScreeningNotFoundException("Screening not found with ID: " + userId);
        }

        return triagens.stream()
                .map(triagemConverter::objectToOutput)
                .collect(Collectors.toList());
    }

    public TriagemOutput updateTriagem(UUID id, UpdateTriagemInput updateTriagemInput) {
        return triagemRepository.findById(id).map(existingTriagem -> {
            existingTriagem.setUsuarioId(updateTriagemInput.getUsuarioId());
            existingTriagem.setIdade(updateTriagemInput.getIdade());
            existingTriagem.setProfissao(updateTriagemInput.getProfissao());
            existingTriagem.setPerfilLinkedin(updateTriagemInput.getPerfilLinkedin());
            existingTriagem.setAreaAtuacao(updateTriagemInput.getAreaAtuacao());
            existingTriagem.setCargoAtual(updateTriagemInput.getCargoAtual());
            existingTriagem.setAreaDeInteresse(updateTriagemInput.getAreaDeInteresse());
            existingTriagem.setCargoDeInteresse(updateTriagemInput.getCargoDeInteresse());
            existingTriagem.setTempoParaAlcancarObjetivo(updateTriagemInput.getTempoParaAlcancarObjetivo());

            Triagem updatedEntity = triagemRepository.save(existingTriagem);
            return triagemConverter.objectToOutput(updatedEntity);
        }).orElseThrow(() -> new ScreeningNotFoundException("Screening not found with ID: " + id));
    }
}
