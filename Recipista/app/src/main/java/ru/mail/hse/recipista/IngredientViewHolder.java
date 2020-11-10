package ru.mail.hse.recipista;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class IngredientViewHolder extends RecyclerView.ViewHolder {

    TextView ingredientTV = itemView.findViewById(R.id.ingredient_tv);

    public IngredientViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    void bind(String ingredient) {
        ingredientTV.setText(ingredient);
    }
}
