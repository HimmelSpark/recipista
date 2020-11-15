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

public class MealClient {

    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";

    public void getAllIngredients(Callback<AllIngredientsDto> callback) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MealApi mealApi = retrofit.create(MealApi.class);
        Call<AllIngredientsDto> call = mealApi.getAllIngredients();
        call.enqueue(callback);
    }
}
