package com.consultoria.triagem.application.useCases;

import com.consultoria.triagem.application.domain.screening.Screening;
import com.consultoria.triagem.application.useCases.converter.ScreeningConverter;
import com.consultoria.triagem.model.input.CreateScreeningDTO;
import com.consultoria.triagem.model.output.ScreeningDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ScreeningUseCase {

    private final ScreeningConverter screeningConverter;

    public ScreeningDTO makeScreening(CreateScreeningDTO createScreeningDTO) {
        System.out.println("Entrou na Usecase");

        Screening screeningConverterInput = screeningConverter.screeningConverterInput(createScreeningDTO);


        return null;
    }

}
