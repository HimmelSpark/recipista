package ru.mail.hse.recipista.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.mail.hse.recipista.R;
import ru.mail.hse.recipista.dto.IngredientDto;
import ru.mail.hse.recipista.viewholder.IngredientViewHolder;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientViewHolder> {

    private List<IngredientDto> ingredients = new ArrayList<>();

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View layout = inflater.inflate(R.layout.ingredient_list_element, parent, false);
        return new IngredientViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        IngredientDto ingredientDto = ingredients.get(position);
        String strIngredient = ingredientDto.getStrIngredient();
        holder.bind(strIngredient);
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public void setIngredients(List<IngredientDto> ingredientDtoList) {
        this.ingredients.clear();
        this.ingredients.addAll(ingredientDtoList);
        notifyDataSetChanged();
    }
}
