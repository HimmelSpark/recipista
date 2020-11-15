package ru.mail.hse.recipista.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Optional;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mail.hse.recipista.api.MealApi;
import ru.mail.hse.recipista.dto.AllIngredientsDto;

public class MealClient implements Callback<AllIngredientsDto> {

    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";

    public void getAllIngredients() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MealApi mealApi = retrofit.create(MealApi.class);
        Call<AllIngredientsDto> call = mealApi.getAllIngredients();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<AllIngredientsDto> call, Response<AllIngredientsDto> response) {
        if (response.isSuccessful()) {
            Optional.of(response)
                    .map(Response::body)
                    .map(AllIngredientsDto::getMeals)
                    .ifPresent(list -> list.forEach(i -> System.out.println(i.getStrIngredient())));
        } else {
            System.out.println("kaka");
        }
    }

    @Override
    public void onFailure(Call<AllIngredientsDto> call, Throwable t) {
        t.printStackTrace();
        //TODO добавить alert notifier
    }
}
