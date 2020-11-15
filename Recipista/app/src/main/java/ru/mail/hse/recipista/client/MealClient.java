package ru.mail.hse.recipista.client;

import lombok.RequiredArgsConstructor;
import retrofit2.Call;
import retrofit2.Callback;
import ru.mail.hse.recipista.api.MealApi;
import ru.mail.hse.recipista.dto.AllIngredientsDto;

@RequiredArgsConstructor
public class MealClient {

    private final MealApi mealApi;

    public void getAllIngredients(Callback<AllIngredientsDto> callback) {

        Call<AllIngredientsDto> call = mealApi.getAllIngredients();
        call.enqueue(callback);
    }
}
