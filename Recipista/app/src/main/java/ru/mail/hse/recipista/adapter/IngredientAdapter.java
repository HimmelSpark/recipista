package ru.mail.hse.recipista.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.mail.hse.recipista.R;
import ru.mail.hse.recipista.viewholder.IngredientViewHolder;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientViewHolder> {

    private List<String> ingredients;

    public IngredientAdapter(List<String> ingredients) {
        this.ingredients = ingredients;
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
