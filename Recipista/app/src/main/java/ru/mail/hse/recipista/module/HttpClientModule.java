package ru.mail.hse.recipista.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mail.hse.recipista.api.MealApi;
import ru.mail.hse.recipista.client.MealClient;

@Module
public class HttpClientModule {

    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";

    @Provides
    public MealClient mealClient(MealApi mealApi) {
        return new MealClient(mealApi);
    }

    @Provides
    public MealApi mealApi(Retrofit retrofit) {
        return retrofit.create(MealApi.class);
    }

    @Provides
    public Retrofit retrofit(Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides Gson gson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }
}
