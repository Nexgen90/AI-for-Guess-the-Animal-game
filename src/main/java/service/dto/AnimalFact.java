package service.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Created by nikolay.mikutskiy
 * Date: 01.07.2021
 */
@Getter
@RequiredArgsConstructor
public class AnimalFact {
    private final Animal firstAnimal;
    private final Animal secondAnimal;
    @Setter
    private String firstAnimalStatement;
    @Setter
    private String secondAnimalStatement;
    @Setter
    private String questionToDistinct;
}
