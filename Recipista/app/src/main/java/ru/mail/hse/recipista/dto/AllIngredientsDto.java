package ru.mail.hse.recipista.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AllIngredientsDto {

    private List<IngredientDto> meals;
}
