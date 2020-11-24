package ru.mail.hse.recipista.api;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.mail.hse.recipista.dto.AllIngredientsDto;

public interface MealApi {

    @GET("list.php/?i=list")
    Call<AllIngredientsDto> getAllIngredients();
}
