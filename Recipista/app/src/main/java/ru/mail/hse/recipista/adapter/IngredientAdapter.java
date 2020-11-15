package ru.mail.hse.recipista.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mail.hse.recipista.R;
import ru.mail.hse.recipista.client.MealClient;
import ru.mail.hse.recipista.component.DaggerHttpComponent;
import ru.mail.hse.recipista.component.HttpComponent;
import ru.mail.hse.recipista.dto.AllIngredientsDto;
import ru.mail.hse.recipista.dto.IngredientDto;
import ru.mail.hse.recipista.viewholder.IngredientViewHolder;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientViewHolder> {

    private List<String> ingredients;

    public IngredientAdapter() {
        final List<String> ingredientList = new ArrayList<>();
        IngredientAdapter adapter = this;
        HttpComponent httpComponent = DaggerHttpComponent.builder().build();
        MealClient mealClient = httpComponent.getMealClient();
        mealClient.getAllIngredients(new Callback<AllIngredientsDto>() {

            @Override
            public void onResponse(Call<AllIngredientsDto> call, Response<AllIngredientsDto> response) {
                if (response.isSuccessful()) {
                    List<IngredientDto> ingredientDtos = Optional.of(response)
                            .map(Response::body)
                            .map(AllIngredientsDto::getMeals)
                            .get();
                    List<String> ingredients = ingredientDtos.stream()
                            .map(IngredientDto::getStrIngredient)
                            .collect(Collectors.toList());
                    ingredientList.addAll(ingredients);
                    adapter.notifyDataSetChanged();
                } else {
                    System.out.println("kaka");
                }
            }

            @Override
            public void onFailure(Call<AllIngredientsDto> call, Throwable t) {
                t.printStackTrace();
                //TODO добавить alert notifier
            }
        });
        this.ingredients = ingredientList;
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View layout = inflater.inflate(R.layout.list_element, parent, false);

        return new IngredientViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        holder.bind(ingredients.get(position));
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }
}
