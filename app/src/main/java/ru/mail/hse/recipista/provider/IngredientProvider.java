package ru.mail.hse.recipista.provider;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mail.hse.recipista.client.MealClient;
import ru.mail.hse.recipista.component.DaggerHttpComponent;
import ru.mail.hse.recipista.component.HttpComponent;
import ru.mail.hse.recipista.dto.AllIngredientsDto;
import ru.mail.hse.recipista.dto.IngredientDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IngredientProvider {

    private static HttpComponent httpComponent = DaggerHttpComponent.builder().build();
    private static MealClient mealClient = httpComponent.getMealClient();

    public static void loadIngredientDTOs(Consumer<List<IngredientDto>> after) {
        mealClient.getAllIngredients(new Callback<AllIngredientsDto>() {

            @Override
            public void onResponse(Call<AllIngredientsDto> call, Response<AllIngredientsDto> response) {
                if (response.isSuccessful()) {
                    List<IngredientDto> ingredientDTOs = Optional.of(response)
                            .map(Response::body)
                            .map(AllIngredientsDto::getMeals)
                            .get();
                    after.accept(ingredientDTOs);
                }
            }

            @Override
            public void onFailure(Call<AllIngredientsDto> call, Throwable t) {
                t.printStackTrace();
                //TODO добавить alert notifier
            }
        });
    }
}
